package cn.zhumouren.twitter.cloud.tweet.controller;


import cn.zhumouren.twitter.cloud.tweet.constant.PageConstants;
import cn.zhumouren.twitter.cloud.tweet.controller.config.ResponseResultBody;
import cn.zhumouren.twitter.cloud.tweet.entity.Tweet;
import cn.zhumouren.twitter.cloud.tweet.service.ITweetService;
import cn.zhumouren.twitter.cloud.tweet.service.exception.TweetNotExistException;
import cn.zhumouren.twitter.cloud.tweet.utils.JwtUtils;
import cn.zhumouren.twitter.cloud.tweet.dto.PostTweetDTO;
import cn.zhumouren.twitter.cloud.tweet.dto.PostReplyTweetDTO;
import cn.zhumouren.twitter.cloud.tweet.vo.TweetLinkVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
     * @param postTweetDTO
     * @param accessToken
     * @return
     */
    @PostMapping("/tweet")
    public boolean postTweet(@RequestBody PostTweetDTO postTweetDTO,
                             @RequestHeader("access_token") String accessToken) {
        Long userId = JwtUtils.getLongByString(accessToken, "uid");
        return tweetService.postTweet(postTweetDTO.getContent(), postTweetDTO.getPics(), userId);
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
     * @param postReplyTweetDTO
     * @param accessToken
     * @return
     */
    @PostMapping("/tweet/reply")
    public boolean postTweetReply(@RequestBody PostReplyTweetDTO postReplyTweetDTO,
                                  @RequestHeader("access_token") String accessToken) throws TweetNotExistException {
        Long pId = Long.valueOf(postReplyTweetDTO.getParentId());
        Long userId = JwtUtils.getLongByString(accessToken, "uid");
        return tweetService.postTweetReply(pId, postReplyTweetDTO.getReplyContent(), postReplyTweetDTO.getReplyPics(), userId);
    }

    /**
     * 获得具体的推文链
     *
     * @param tweetId
     * @param current
     * @param size
     * @return
     */
    @GetMapping("/status/{tweetId}")
    public TweetLinkVO getTweetLinkVO(@PathVariable("tweetId") String tweetId,
                                      @RequestParam(value = "current", required = false) Integer current,
                                      @RequestParam(value = "size", required = false) Integer size) {
        Page<Tweet> page = new Page<>();
        Long tId = Long.valueOf(tweetId);
        PageConstants.constantPageConfig(page, current, size);
        return tweetService.getTweetLinkVO(page, tId);
    }

    /**
     * 获得用户的推文(不包括回复)
     *
     * @param userId
     * @param current
     * @param size
     * @return
     */
    @GetMapping("/{userId}/tweets")
    public IPage<Tweet> getUserTweetPage(@PathVariable("userId") String userId,
                                         @RequestParam(value = "current", required = false) Integer current,
                                         @RequestParam(value = "size", required = false) Integer size) {
        Page<Tweet> page = new Page<>();
        PageConstants.constantPageConfig(page, current, size);
        Long uid = Long.valueOf(userId);
        return tweetService.getUserTweetPage(page, uid);
    }




}
