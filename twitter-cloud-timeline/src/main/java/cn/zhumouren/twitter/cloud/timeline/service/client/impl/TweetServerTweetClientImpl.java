package cn.zhumouren.twitter.cloud.timeline.service.client.impl;

import cn.zhumouren.twitter.cloud.constant.exception.TweetDeletedException;
import cn.zhumouren.twitter.cloud.constant.exception.TweetNotExistException;
import cn.zhumouren.twitter.cloud.timeline.domain.StatusJson;
import cn.zhumouren.twitter.cloud.timeline.service.client.ITweetServerTweetClient;
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
public class TweetServerTweetClientImpl {

    @Autowired
    private ITweetServerTweetClient tweetClientService;

    public List<Long> listUserStatusId(Long userId){
        JSONObject jsonObject = tweetClientService.listUserStatusId(userId.toString());
        List<Long> userStatusIdList = StatusJsonUtil.listStatusId(jsonObject);
        return userStatusIdList;
    }

    public StatusJson getStatus(Long statusId) throws TweetNotExistException, TweetDeletedException {
        JSONObject jsonObject = tweetClientService.getStatus(statusId.toString());
        StatusJson status = StatusJsonUtil.getStatus(jsonObject);
        return status;
    }

    public List<StatusJson> listUserStatusJson(Long userId){
        JSONObject jsonObject = tweetClientService.listUserStatus(userId.toString());
        List<StatusJson> statusList = StatusJsonUtil.listStatus(jsonObject);
        return statusList;
    }

}
