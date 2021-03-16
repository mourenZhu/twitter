package cn.zhumouren.twitter.cloud.timeline.service.impl;

import cn.zhumouren.twitter.cloud.timeline.constant.redis.ExpireConstant;
import cn.zhumouren.twitter.cloud.timeline.constant.redis.UserKeyConstant;
import cn.zhumouren.twitter.cloud.timeline.domain.ForwardJson;
import cn.zhumouren.twitter.cloud.timeline.service.IUserPostsService;
import cn.zhumouren.twitter.cloud.timeline.service.client.impl.TweetServerForwardClientImpl;
import cn.zhumouren.twitter.cloud.timeline.service.client.impl.TweetServerTweetClientImpl;
import cn.zhumouren.twitter.cloud.timeline.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/24 23:49
 * @Version 1.0
 **/
@Service
public class UserPostsServiceImpl implements IUserPostsService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ExpireConstant expireConstant;

    @Autowired
    private TweetServerTweetClientImpl tweetClient;

    @Autowired
    private TweetServerForwardClientImpl forwardClient;


    @Override
    public boolean isExistUserTimeline(Long userId) {
        return redisUtil.hasKey(UserKeyConstant.getUserPostsKey(userId.toString()));
    }

    @Override
    public boolean creatUserPosts(Long userId) {
        if (!isExistUserTimeline(userId)) {
            List<Long> statusIdList = tweetClient.listUserStatusId(userId);
            String key = UserKeyConstant.getUserPostsKey(userId.toString());
            return redisUtil.lRightPushAll(key, statusIdList, expireConstant.getPostsTime());
        }
        return true;
    }

    @Override
    public boolean creatUserForwards(Long userId) {
        String key = UserKeyConstant.getUserForwardKey(userId.toString());
        if (!redisUtil.hasKey(key)) {
            List<ForwardJson> forwardJsons = forwardClient.listUserForward(userId);
            return redisUtil.lRightPushAll(key, forwardJsons, expireConstant.getPostsTime());
        }
        return false;
    }

}
