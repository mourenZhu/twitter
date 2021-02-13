package cn.zhumouren.twitter.cloud.tweet.service.impl;

import cn.zhumouren.twitter.cloud.tweet.entity.Path;
import cn.zhumouren.twitter.cloud.tweet.entity.Tweet;
import cn.zhumouren.twitter.cloud.tweet.mapper.PathMapper;
import cn.zhumouren.twitter.cloud.tweet.mapper.TweetMapper;
import cn.zhumouren.twitter.cloud.tweet.service.ITweetService;
import cn.zhumouren.twitter.cloud.tweet.vo.TweetLinkVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 推文表 服务实现类
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Service
public class TweetServiceImpl extends ServiceImpl<TweetMapper, Tweet> implements ITweetService {

    @Autowired
    private TweetMapper tweetMapper;

    @Autowired
    private PathMapper pathMapper;

    @Transactional
    public boolean post(Long parentId, String content, String pics, Long uid) {
        Tweet tweet = new Tweet();
        tweet.setUserId(uid);
        tweet.setContent(content);
        tweet.setPics(pics);
        int isPostTweet = tweetMapper.insert(tweet);
        int isPostPath = pathMapper.insert(new Path(parentId, tweet.getId()));
        return SqlHelper.retBool(isPostTweet) && SqlHelper.retBool(isPostPath);
    }

    @Override
    public boolean postTweet(String content, Long uid) {
        return postTweet(content, "", uid);
    }

    @Override
    public boolean postTweet(String content, String pics, Long uid) {
        return post(0L, content, pics, uid);
    }

    @Transactional
    @Override
    public boolean deletedTweet(Long tweetId, Long uid) {
        return tweetMapper.deletedTweet(tweetId, uid) && pathMapper.deletedTweetChildPath(tweetId);
    }

    @Override
    public boolean postTweetReply(Long parentId, String replyContent, Long uid) {
        return postTweetReply(parentId, replyContent, "", uid);
    }

    @Override
    public boolean postTweetReply(Long parentId, String replyContent, String replyPics, Long uid) {
        return post(parentId, replyContent, replyPics, uid);
    }

    @Override
    public TweetLinkVO getTweetLinkVO(Long tweetId) {

        return null;
    }
}
