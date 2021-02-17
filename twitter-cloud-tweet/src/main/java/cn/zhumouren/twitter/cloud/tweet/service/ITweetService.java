package cn.zhumouren.twitter.cloud.tweet.service;

import cn.zhumouren.twitter.cloud.tweet.entity.Tweet;
import cn.zhumouren.twitter.cloud.tweet.service.exception.TweetNotExistException;
import cn.zhumouren.twitter.cloud.tweet.vo.TweetLinkVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 推文表 服务类
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
public interface ITweetService extends IService<Tweet> {

    /**
     * 提交推文，并需要在path中添加记录
     *
     * @param content
     * @param uid
     * @return
     */
    boolean postTweet(String content, Long uid);

    /**
     * 提交推文（包括图片），并需要在path添加记录
     *
     * @param content
     * @param pics
     * @param uid
     * @return
     */
    boolean postTweet(String content, String pics, Long uid);

    /**
     * 删除推文，但不是真删
     *
     * @param tweetId
     * @param uid
     * @return
     */
    boolean deletedTweet(Long tweetId, Long uid);

    /**
     * 推文回复，并在path中添加记录
     *
     * @param parentId
     * @param replyContent
     * @param uid
     * @return
     * @throws TweetNotExistException
     */
    boolean postTweetReply(Long parentId, String replyContent, Long uid) throws TweetNotExistException;

    /**
     * 推文回复（添加图片），并在path中添加记录
     *
     * @param parentId
     * @param replyContent
     * @param replyPics
     * @param uid
     * @return
     * @throws TweetNotExistException
     */
    boolean postTweetReply(Long parentId, String replyContent, String replyPics, Long uid) throws TweetNotExistException;

    /**
     * 获得推文链前端展示对象
     *
     * @param tweetId
     * @return
     */
    TweetLinkVO getTweetLinkVO(Long tweetId);

}
