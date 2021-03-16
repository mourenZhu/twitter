package cn.zhumouren.twitter.cloud.timeline.service.client.impl;

import cn.zhumouren.twitter.cloud.timeline.domain.ForwardJson;
import cn.zhumouren.twitter.cloud.timeline.service.client.ITweetServerForwardClient;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/16 14:21
 * @Version 1.0
 **/
@Service
public class TweetServerForwardClientImpl {

    @Autowired
    private ITweetServerForwardClient forwardClient;

    public List<ForwardJson> listUserForward(Long userId) {
        JSONObject jsonObject = forwardClient.listUserForward(userId.toString());
        return toList(jsonObject, "data", ForwardJson.class);
    }


    public List<Long> listForwardUserId(Long statusId) {
        JSONObject jsonObject = forwardClient.listForwardUserId(statusId.toString());
        return toList(jsonObject, "data", Long.class);
    }

    private <T> List<T> toList(JSONObject jsonObject, String key, Class<T> type) {
        List object = jsonObject.getObject(key, List.class);
        return JSON.parseArray(JSON.toJSONString(object), type);
    }
}
