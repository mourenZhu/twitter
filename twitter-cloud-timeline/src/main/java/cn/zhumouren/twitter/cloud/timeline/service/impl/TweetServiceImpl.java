package cn.zhumouren.twitter.cloud.timeline.service.impl;

import cn.zhumouren.twitter.cloud.timeline.domain.StatusJson;
import cn.zhumouren.twitter.cloud.timeline.service.ITweetService;
import cn.zhumouren.twitter.cloud.timeline.utils.StatusJsonUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/25 0:06
 * @Version 1.0
 **/
@Service
public class TweetServiceImpl {
    @Autowired
    private ITweetService tweetService;

    public List<Long> listUserStatusId(Long userId){
        JSONObject jsonObject = tweetService.listUserStatusId(userId.toString());
        List<Long> userStatusIdList = StatusJsonUtil.listStatusId(jsonObject);
        return userStatusIdList;
    }

    public StatusJson getStatus(Long statusId){
        JSONObject jsonObject = tweetService.getStatus(statusId.toString());
        StatusJson status = StatusJsonUtil.getStatus(jsonObject);
        return status;
    }

    public List<StatusJson> listUserStatusJson(Long userId){
        JSONObject jsonObject = tweetService.listUserStatus(userId.toString());
        List<StatusJson> statusList = StatusJsonUtil.listStatus(jsonObject);
        return statusList;
    }

}
