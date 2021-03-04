package cn.zhumouren.twitter.cloud.tweet.service.impl;

import cn.zhumouren.twitter.cloud.constant.exception.TweetNotExistException;
import cn.zhumouren.twitter.cloud.tweet.dto.StatusDTO;
import cn.zhumouren.twitter.cloud.tweet.entity.ParentChildTweet;
import cn.zhumouren.twitter.cloud.tweet.entity.Tweet;
import cn.zhumouren.twitter.cloud.tweet.mapper.ParentChildTweetMapper;
import cn.zhumouren.twitter.cloud.tweet.mapper.TweetMapper;
import cn.zhumouren.twitter.cloud.tweet.service.ITweetService;
import cn.zhumouren.twitter.cloud.tweet.vo.TweetLinkVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    private ParentChildTweetMapper parentChildTweetMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean post(String content, List<String> pics, Long uid) {
        Tweet tweet = new Tweet();
        tweet.setUserId(uid);
        tweet.setContent(content);
        tweet.setPics(pics);
        int isPostTweet = tweetMapper.insert(tweet);
        int isParentChildTweet = parentChildTweetMapper.insert(new ParentChildTweet(tweet.getId(), tweet.getId(), 0, true));
        return SqlHelper.retBool(isPostTweet) && SqlHelper.retBool(isParentChildTweet);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean postReply(Long parentId, String content, List<String> pics, Long uid) {
        Tweet tweet = new Tweet();
        tweet.setUserId(uid);
        tweet.setContent(content);
        tweet.setPics(pics);
        int isPostTweet = tweetMapper.insert(tweet);
        boolean isPostTweetReply = parentChildTweetMapper.postTweetReply(parentId, tweet.getId());
        int isParentChildTweet = parentChildTweetMapper.insert(new ParentChildTweet(tweet.getId(), tweet.getId(), 0, false));
        boolean isReplyNums = tweetMapper.addReplyNums(parentId);
        return SqlHelper.retBool(isPostTweet) && isPostTweetReply && SqlHelper.retBool(isParentChildTweet) && isReplyNums;
    }

    @Override
    public boolean postTweet(String content, Long uid) {
        List<String> pics = new ArrayList();
        return postTweet(content, pics, uid);
    }

    @Override
    public boolean postTweet(String content, List<String> pics, Long uid) {
        return post(content, pics, uid);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deletedTweet(Long tweetId, Long uid) {
        boolean isReplyNums = true;
        Long parentId = parentChildTweetMapper.getParentId(tweetId, 1);
        if (null != parentId) {
            isReplyNums = tweetMapper.subReplyNums(parentId);
        }
        return tweetMapper.deletedTweet(tweetId, uid) && parentChildTweetMapper.deletedTweet(tweetId) && isReplyNums;
    }

    @Override
    public boolean postTweetReply(Long parentId, String replyContent, Long uid) throws TweetNotExistException {
        List<String> pics = new ArrayList<>();
        return postTweetReply(parentId, replyContent, pics, uid);
    }

    @Override
    public boolean postTweetReply(Long parentId, String replyContent, List<String> replyPics, Long uid) throws TweetNotExistException {
        if (tweetMapper.isExistTweet(parentId)) {
            return postReply(parentId, replyContent, replyPics, uid);
        } else {
            throw new TweetNotExistException();
        }
    }

    @Override
    public TweetLinkVO getTweetLinkVO(Page<Tweet> page, Long tweetId) {
        List<Tweet> tweetList = tweetMapper.listParentTweet(tweetId);
        IPage<Tweet> childTweetPage = tweetMapper.getChildTweetPage(page, tweetId);
        Tweet currentTweet = tweetList.remove(tweetList.size() - 1);
        return new TweetLinkVO(tweetList, currentTweet, childTweetPage);
    }

    @Override
    public IPage<Tweet> getUserTweetPage(Page<Tweet> page, Long userId) {
        return tweetMapper.getUserTweetPage(page, userId);
    }

    @Override
    public List<String> listUserStatusId(Long userId) {
        return tweetMapper.listUserStatusId(userId);
    }

    @Override
    public List<StatusDTO> listUserStatus(Long userId) {
        return tweetMapper.listUserStatus(userId);
    }

    @Override
    public StatusDTO getStatus(Long statusId) throws TweetNotExistException {
        if (tweetMapper.isExistTweet(statusId)) {
            return tweetMapper.getStatus(statusId);
        } else {
            throw new TweetNotExistException();
        }
    }

    @Override
    public List<StatusDTO> listStatus(List<Long> statusIdList) {
        return tweetMapper.listStatus(statusIdList);
    }
}
