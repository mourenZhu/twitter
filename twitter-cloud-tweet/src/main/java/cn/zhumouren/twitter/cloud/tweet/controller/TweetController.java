package cn.zhumouren.twitter.cloud.tweet.controller;


import cn.zhumouren.twitter.cloud.tweet.entity.Tweet;
import cn.zhumouren.twitter.cloud.tweet.service.ITweetService;
import cn.zhumouren.twitter.cloud.tweet.utils.JwtUtils;
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

    @DeleteMapping("/tweet")
    public boolean deletedTweet(@RequestParam("tweet_id") String tweetId,
                                @RequestHeader("access_token") String accessToken) {

        return false;
    }

}
