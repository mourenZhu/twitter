package cn.zhumouren.twitter.cloud.tweet.controller;


import cn.zhumouren.twitter.cloud.tweet.service.ITweetService;
import cn.zhumouren.twitter.cloud.tweet.utils.JwtUtils;
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
public class TweetController {

    @Autowired
    private ITweetService tweetService;

    /**
     * 提交推文
     *
     * @param content
     * @param accessToken
     * @return
     */
    @PostMapping("/tweet")
    public boolean postTweet(@RequestParam("content") String content, @RequestParam("pics") String pics,
                             @RequestHeader("access_token") String accessToken) {
        Long userId = JwtUtils.getLongByString(accessToken, "uid");
        return tweetService.postTweet(content, pics, userId);
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
     * @param parentId
     * @param replyContent
     * @param pics
     * @param accessToken
     * @return
     */
    @PostMapping("/tweet/reply")
    public boolean postTweetReply(@RequestParam("parent_id") String parentId,
                                  @RequestParam("reply_content") String replyContent,
                                  @RequestParam("pics") String pics,
                                  @RequestHeader("access_token") String accessToken) {
        Long pId = Long.valueOf(parentId);
        Long userId = JwtUtils.getLongByString(accessToken, "uid");
        return tweetService.postTweetReply(pId, replyContent, pics, userId);
    }

    public TweetLinkVO getTweetLinkVO(@RequestParam("tweet_id") String tweetId){
        return null;
    }

}
