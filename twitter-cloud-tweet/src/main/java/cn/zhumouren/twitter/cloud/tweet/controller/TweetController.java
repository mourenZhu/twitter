package cn.zhumouren.twitter.cloud.tweet.controller;


import cn.zhumouren.twitter.cloud.tweet.controller.config.ResponseResultBody;
import cn.zhumouren.twitter.cloud.tweet.service.ITweetService;
import cn.zhumouren.twitter.cloud.tweet.service.exception.TweetNotExistException;
import cn.zhumouren.twitter.cloud.tweet.utils.JwtUtils;
import cn.zhumouren.twitter.cloud.tweet.vo.PostTweetVO;
import cn.zhumouren.twitter.cloud.tweet.vo.ReplyTweetVO;
import cn.zhumouren.twitter.cloud.tweet.vo.TweetLinkVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 推文表 前端控制器
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@RestController
@RequestMapping
@ResponseResultBody
public class TweetController {

    @Autowired
    private ITweetService tweetService;

    /**
     * 提交推文
     *
     * @param postTweetVO
     * @param accessToken
     * @return
     */
    @PostMapping("/tweet")
    public boolean postTweet(@RequestBody PostTweetVO postTweetVO,
                             @RequestHeader("access_token") String accessToken) {
        Long userId = JwtUtils.getLongByString(accessToken, "uid");
        return tweetService.postTweet(postTweetVO.getContent(), postTweetVO.getPics(), userId);
    }

    /**
     * 删除推文
     *
     * @param tweetId
     * @param accessToken
     * @return
     */
    @DeleteMapping("/tweet")
    public boolean deletedTweet(@RequestParam("tweet_id") String tweetId,
                                @RequestHeader("access_token") String accessToken) {
        Long tId = Long.valueOf(tweetId);
        Long userId = JwtUtils.getLongByString(accessToken, "uid");
        return tweetService.deletedTweet(tId, userId);
    }

    /**
     * 发布推文回复
     *
     * @param replyTweetVO
     * @param accessToken
     * @return
     */
    @PostMapping("/tweet/reply")
    public boolean postTweetReply(@RequestBody ReplyTweetVO replyTweetVO,
                                  @RequestHeader("access_token") String accessToken) throws TweetNotExistException {
        Long pId = Long.valueOf(replyTweetVO.getParentId());
        Long userId = JwtUtils.getLongByString(accessToken, "uid");
        return tweetService.postTweetReply(pId, replyTweetVO.getReplyContent(), replyTweetVO.getReplyPics(), userId);
    }

    public TweetLinkVO getTweetLinkVO(@RequestParam("tweet_id") String tweetId) {
        return null;
    }


}
