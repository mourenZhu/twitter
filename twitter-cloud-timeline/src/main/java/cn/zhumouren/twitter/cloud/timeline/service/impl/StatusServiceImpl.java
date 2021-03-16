package cn.zhumouren.twitter.cloud.timeline.service.impl;

import cn.zhumouren.twitter.cloud.constant.exception.TweetDeletedException;
import cn.zhumouren.twitter.cloud.constant.exception.TweetNotExistException;
import cn.zhumouren.twitter.cloud.constant.exception.UserNotExistException;
import cn.zhumouren.twitter.cloud.timeline.constant.redis.ExpireConstant;
import cn.zhumouren.twitter.cloud.timeline.constant.redis.StatusKeyConstant;
import cn.zhumouren.twitter.cloud.timeline.domain.StatusJson;
import cn.zhumouren.twitter.cloud.timeline.domain.UserJson;
import cn.zhumouren.twitter.cloud.timeline.service.IStatusService;
import cn.zhumouren.twitter.cloud.timeline.service.IUserService;
import cn.zhumouren.twitter.cloud.timeline.service.client.impl.TweetServerForwardClientImpl;
import cn.zhumouren.twitter.cloud.timeline.service.client.impl.TweetServerTweetClientImpl;
import cn.zhumouren.twitter.cloud.timeline.utils.RedisUtil;
import cn.zhumouren.twitter.cloud.timeline.utils.StatusJsonUtil;
import cn.zhumouren.twitter.cloud.timeline.vo.ErrorStatusVO;
import cn.zhumouren.twitter.cloud.timeline.vo.StatusLinkVO;
import cn.zhumouren.twitter.cloud.timeline.vo.StatusVO;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/25 0:14
 * @Version 1.0
 **/
@Service
@Slf4j
public class StatusServiceImpl implements IStatusService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private TweetServerTweetClientImpl tweetClient;

    @Autowired
    private TweetServerForwardClientImpl forwardClient;

    @Autowired
    private IUserService userService;

    @Autowired
    private ExpireConstant expireConstant;

    @Override
    public boolean pushStatus(StatusJson statusJson) {
        if (!redisUtil.hasKey(statusJson.getId().toString())) {
            List<String> itemList = StatusJsonUtil.listStatusField();
            for (String s : itemList) {
                try {
                    String key = StatusKeyConstant.getStatusKey(statusJson.getId().toString());
                    Object value = StatusJsonUtil.getStatusFieldValue(s, statusJson);
                    redisUtil.hset(key, s, value, expireConstant.getStatusTime());
                } catch (NoSuchFieldException e) {
                    log.error(e.getMessage());
                } catch (IllegalAccessException e) {
                    log.error(e.getMessage());
                }
            }
            pushStatusChildId(statusJson.getId());
            pushForwardUserid(statusJson.getId());
        }
        return true;
    }

    /**
     * 提交推文子推文id
     *
     * @param statusId
     * @return
     */
    private boolean pushStatusChildId(Long statusId) {
        String key = StatusKeyConstant.getStatusChildIdKey(statusId.toString());
        List<Long> values = tweetClient.listStatusChildId(statusId);
        if (values.size() > 0) {
            return redisUtil.lLeftPushAll(key, values, expireConstant.getStatusTime());
        }
        return false;
    }

    /**
     * 提交推文转发的user id
     *
     * @param statusId
     * @return
     */
    private boolean pushForwardUserid(Long statusId) {
        String key = StatusKeyConstant.getForwardUidKey(statusId.toString());
        List<Long> values = forwardClient.listForwardUserId(statusId);
        if (values.size() > 0) {
            return redisUtil.lLeftPushAll(key, values, expireConstant.getStatusTime());
        }
        return false;
    }

    /**
     * 获取推文子推文id
     *
     * @param statusId
     * @return
     */
    private List<Long> listStatusChildId(Long statusId) {
        List<Long> statusChildIdList = new LinkedList<>();
        String key = StatusKeyConstant.getStatusChildIdKey(statusId.toString());
        if (!redisUtil.hasKey(key)) {
            pushStatusChildId(statusId);
        }
        List<Object> objects = redisUtil.lGet(key, 0, redisUtil.lGetListSize(key));
        for (Object o : objects) {
            statusChildIdList.add((Long) o);
        }
        return statusChildIdList;
    }

    @Override
    public boolean pushStatusList(List<StatusJson> statusJsons) {
        boolean bool = true;
        for (StatusJson statusJson : statusJsons) {
            bool = pushStatus(statusJson);
        }
        return bool;
    }

    @Override
    public StatusJson getStatusJson(Long statusId) throws TweetNotExistException, TweetDeletedException {
        if (!redisUtil.hasKey(StatusKeyConstant.getStatusKey(statusId.toString()))) {
            pushStatus(tweetClient.getStatus(statusId));
        }
        Map<Object, Object> statusMap = redisUtil.hmget(StatusKeyConstant.getStatusKey(statusId.toString()));
        StatusJson statusJson = JSONObject.parseObject(JSONObject.toJSONString(statusMap), StatusJson.class);
        if (statusJson.getDeleted()) {
            throw new TweetDeletedException();
        }
        return statusJson;
    }

    /**
     * 推文不存在或推文已删除的不会出现在list中
     *
     * @param statusIdList
     * @return
     */
    @Override
    public List<StatusJson> listStatusJson(List<Long> statusIdList) {
        List<StatusJson> statusJsonList = new LinkedList();
        for (Long l : statusIdList) {
            try {
                statusJsonList.add(getStatusJson(l));
            } catch (TweetNotExistException | TweetDeletedException e) {
                log.error(e.getMessage() + "id===" + l);
            }
        }
        return statusJsonList;
    }

    @Override
    public StatusVO getStatusVO(Long statusId) throws TweetNotExistException, UserNotExistException, TweetDeletedException {
        StatusJson statusJson = getStatusJson(statusId);
        UserJson user = userService.getUser(statusJson.getUserId());
        List<String> parentUsernames = userService.listUsername(statusJson.getParentTweetUserIds());
        StatusVO statusVO = new StatusVO(statusJson, user, parentUsernames);
        return statusVO;
    }

    /**
     * 推文不存在或推文已删除的不会出现在list中
     *
     * @param statusIdList
     * @return
     */
    @Override
    public List<StatusVO> listStatusVO(List<Long> statusIdList) {
        List<StatusVO> statusVOList = new LinkedList<>();
        for (Long l : statusIdList) {
            try {
                statusVOList.add(getStatusVO(l));
            } catch (TweetNotExistException e) {
                log.error(e.getMessage() + "id===" + l);
            } catch (UserNotExistException e) {
                log.error(e.getMessage());
            } catch (TweetDeletedException e) {
                log.error(e.getMessage());
            }
        }
        return statusVOList;
    }

    @Override
    public StatusLinkVO getStatusLinkVO(Long statusId) throws TweetNotExistException, UserNotExistException, TweetDeletedException {

        StatusVO currentStatusVO = getStatusVO(statusId);
        List<Long> parentTweetIds = currentStatusVO.getParentTweetIds();
        List<ErrorStatusVO> parentStatusVOList = listErrorStatusVO(parentTweetIds);
        List<StatusVO> childStatusVOList = listStatusVO(listStatusChildId(statusId));
        StatusLinkVO statusLinkVO = new StatusLinkVO(parentStatusVOList, currentStatusVO, childStatusVOList);
        return statusLinkVO;
    }

    private List<ErrorStatusVO> listErrorStatusVO(List<Long> list) {
        List<ErrorStatusVO> errorStatusVOList = new LinkedList<>();
        for (Long l : list) {
            try {
                StatusVO statusVO = getStatusVO(l);
                errorStatusVOList.add(new ErrorStatusVO(statusVO));
            } catch (TweetNotExistException e) {
                log.error(e.getMessage());
                errorStatusVOList.add(new ErrorStatusVO(l, e.getResultStatus().getCode(), e.getMessage()));
            } catch (UserNotExistException e) {
                log.error(e.getMessage());
                errorStatusVOList.add(new ErrorStatusVO(l, e.getResultStatus().getCode(), e.getMessage()));
            } catch (TweetDeletedException e) {
                log.error(e.getMessage());
                errorStatusVOList.add(new ErrorStatusVO(l, e.getResultStatus().getCode(), e.getMessage()));
            }
        }
        return errorStatusVOList;
    }

}
