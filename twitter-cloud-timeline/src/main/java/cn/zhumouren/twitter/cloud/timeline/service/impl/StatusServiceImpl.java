package cn.zhumouren.twitter.cloud.timeline.service.impl;

import cn.zhumouren.twitter.cloud.constant.exception.TweetNotExistException;
import cn.zhumouren.twitter.cloud.timeline.constant.redis.StatusKeyConstant;
import cn.zhumouren.twitter.cloud.timeline.domain.StatusJson;
import cn.zhumouren.twitter.cloud.timeline.domain.UserJson;
import cn.zhumouren.twitter.cloud.timeline.service.IStatusService;
import cn.zhumouren.twitter.cloud.timeline.service.IUserService;
import cn.zhumouren.twitter.cloud.timeline.service.client.impl.TweetServerTweetClientImpl;
import cn.zhumouren.twitter.cloud.timeline.utils.RedisUtil;
import cn.zhumouren.twitter.cloud.timeline.utils.StatusJsonUtil;
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
    private IUserService userService;

    @Override
    public boolean pushStatus(StatusJson statusJson) {
        if (!redisUtil.hasKey(statusJson.getId().toString())) {
            List<String> itemList = StatusJsonUtil.listStatusField();
            for (String s : itemList) {
                try {
                    redisUtil.hset(StatusKeyConstant.getStatusKey(statusJson.getId().toString()), s, StatusJsonUtil.getStatusFieldValue(s, statusJson));
                } catch (NoSuchFieldException e) {
                    log.error(e.getMessage());
                } catch (IllegalAccessException e) {
                    log.error(e.getMessage());
                }
            }
        }
        return true;
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
    public StatusJson getStatusJson(Long statusId) throws TweetNotExistException {
        if (!redisUtil.hasKey(StatusKeyConstant.getStatusKey(statusId.toString()))) {
            pushStatus(tweetClient.getStatus(statusId));
        }
        Map<Object, Object> statusMap = redisUtil.hmget(StatusKeyConstant.getStatusKey(statusId.toString()));
        StatusJson statusJson = JSONObject.parseObject(JSONObject.toJSONString(statusMap), StatusJson.class);
        return statusJson;
    }

    @Override
    public List<StatusJson> listStatusJson(List<Long> statusIdList) {
        List<StatusJson> statusJsonList = new LinkedList();
        for (Long l : statusIdList) {
            try {
                statusJsonList.add(getStatusJson(l));
            } catch (TweetNotExistException e) {
                log.error(e.getMessage() + "id===" + l);
            }
        }
        return statusJsonList;
    }

    @Override
    public StatusVO getStatusVO(Long statusId) throws TweetNotExistException {
        StatusJson statusJson = getStatusJson(statusId);
        UserJson user = userService.getUser(statusJson.getUserId());
        List<String> parentUsernames = userService.listUsername(statusJson.getParentTweetUserIds());
        StatusVO statusVO = new StatusVO(statusJson, user, parentUsernames);
        return statusVO;
    }

    @Override
    public List<StatusVO> listStatusVO(List<Long> statusIdList) {
        List<StatusVO> statusVOList = new LinkedList<>();
        for (Long l : statusIdList) {
            try {
                statusVOList.add(getStatusVO(l));
            } catch (TweetNotExistException e) {
                log.error(e.getMessage() + "id===" + l);
            }
        }
        return statusVOList;
    }

}
