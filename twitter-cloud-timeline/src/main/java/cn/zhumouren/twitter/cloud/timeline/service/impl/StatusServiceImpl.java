package cn.zhumouren.twitter.cloud.timeline.service.impl;

import cn.zhumouren.twitter.cloud.timeline.constant.redis.StatusKeyConstant;
import cn.zhumouren.twitter.cloud.timeline.domain.StatusJson;
import cn.zhumouren.twitter.cloud.timeline.service.IStatusService;
import cn.zhumouren.twitter.cloud.timeline.utils.RedisUtil;
import cn.zhumouren.twitter.cloud.timeline.utils.StatusJsonUtil;
import com.alibaba.fastjson.JSONObject;
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
public class StatusServiceImpl implements IStatusService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private TweetServiceImpl tweetService;

    @Override
    public boolean pushStatus(StatusJson statusJson) {
        if (!redisUtil.hasKey(statusJson.getId().toString())) {
            List<String> itemList = StatusJsonUtil.listStatusField();
            for (String s : itemList) {
                try {
                    redisUtil.hset(StatusKeyConstant.getStatusKey(statusJson.getId().toString()), s, StatusJsonUtil.getStatusFieldValue(s, statusJson));
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
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
    public StatusJson getStatusJson(Long statusId) {
        if (!redisUtil.hasKey(StatusKeyConstant.getStatusKey(statusId.toString()))) {
            pushStatus(tweetService.getStatus(statusId));
        }
        Map<Object, Object> statusMap = redisUtil.hmget(StatusKeyConstant.getStatusKey(statusId.toString()));
        StatusJson statusJson = JSONObject.parseObject(JSONObject.toJSONString(statusMap), StatusJson.class);
        return statusJson;
    }

    @Override
    public List<StatusJson> listStatusJson(List<Long> statusIdList) {
        List<StatusJson> statusJsonList = new LinkedList();
        for (Long l : statusIdList) {
            statusJsonList.add(getStatusJson(l));
        }
        return statusJsonList;
    }
}
