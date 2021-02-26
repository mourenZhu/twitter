package cn.zhumouren.twitter.cloud.timeline.service.impl;

import cn.zhumouren.twitter.cloud.timeline.constant.redis.UserKeyConstant;
import cn.zhumouren.twitter.cloud.timeline.service.IUserTimelineService;
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
public class UserTimelineServiceImpl implements IUserTimelineService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private TweetServiceImpl tweetService;


    @Override
    public boolean isExistUserTimeline(Long userId) {
        return redisUtil.hasKey(UserKeyConstant.getUserPostsKey(userId.toString()));
    }

    @Override
    public boolean creatUserTimeline(Long userId) {
        if (!isExistUserTimeline(userId)) {
            List<Long> statusIdList = tweetService.listUserStatusId(userId);
            String key = UserKeyConstant.getUserPostsKey(userId.toString());
            return redisUtil.lRightPushAll(key, statusIdList);
        }
        return true;
    }
}
