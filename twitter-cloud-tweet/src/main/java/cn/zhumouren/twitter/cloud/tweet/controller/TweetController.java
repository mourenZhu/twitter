package cn.zhumouren.twitter.cloud.tweet.controller;


import cn.zhumouren.twitter.cloud.constant.exception.TweetDeletedException;
import cn.zhumouren.twitter.cloud.constant.exception.TweetNotExistException;
import cn.zhumouren.twitter.cloud.constant.result.annotation.ResponseResultBody;
import cn.zhumouren.twitter.cloud.constant.utils.jwt.JwtUtils;
import cn.zhumouren.twitter.cloud.constant.utils.list.ListUtils;
import cn.zhumouren.twitter.cloud.tweet.constant.PageConstants;
import cn.zhumouren.twitter.cloud.tweet.dto.PostQuoteTweetDTO;
import cn.zhumouren.twitter.cloud.tweet.dto.PostReplyTweetDTO;
import cn.zhumouren.twitter.cloud.tweet.dto.PostTweetDTO;
import cn.zhumouren.twitter.cloud.tweet.dto.StatusDTO;
import cn.zhumouren.twitter.cloud.tweet.entity.Tweet;
import cn.zhumouren.twitter.cloud.tweet.service.ITweetService;
import cn.zhumouren.twitter.cloud.tweet.vo.TweetLinkVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * 发布引用推文
     *
     * @param postQuoteTweetDTO
     * @param accessToken
     * @return
     */
    @PostMapping("/tweet/quote")
    public boolean postQuote(@RequestBody PostQuoteTweetDTO postQuoteTweetDTO,
                             @RequestHeader("access_token") String accessToken) throws TweetNotExistException {
        Long quotedId = Long.valueOf(postQuoteTweetDTO.getQuotedTweetId());
        Long userId = JwtUtils.getLongByString(accessToken, "uid");
        return tweetService.postTweetQuote(userId, quotedId, postQuoteTweetDTO.getContent(), postQuoteTweetDTO.getPics());
    }

    /**
     * 获得具体的推文链
     *
     * @param tweetId
     * @param current
     * @param size
     * @return
     */
    @GetMapping("/tweet/{tweetId}")
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

    /**
     * 获得用户发布的推文的id
     *
     * @param userId
     * @return
     */
    @GetMapping("/{userId}/list/statusId")
    public List<String> listUserStatusId(@PathVariable("userId") String userId) {
        Long uid = Long.valueOf(userId);
        return tweetService.listUserStatusId(uid);
    }

    /**
     * 获取用户的status（包括推文与回复）
     *
     * @param userId
     * @return
     */
    @GetMapping("/{userId}/list/status")
    public List<StatusDTO> listUserStatus(@PathVariable("userId") String userId) {
        Long uid = Long.valueOf(userId);
        return tweetService.listUserStatus(uid);
    }

    /**
     * 获取单个status
     *
     * @param statusId
     * @return
     */
    @GetMapping("/status/{statusId}")
    public StatusDTO getStatus(@PathVariable("statusId") String statusId) throws TweetNotExistException, TweetDeletedException {
        Long sId = Long.valueOf(statusId);
        return tweetService.getStatus(sId);
    }

    /**
     * @param statusId
     * @return
     */
    @GetMapping("/status/{statusId}/quote/list/userId")
    public List<String> listStatusQuoteUserId(@PathVariable("statusId") String statusId) {
        return null;
    }

    /**
     * 获取status list
     *
     * @param statusIdList
     * @return
     */
    @GetMapping("/list/status")
    public List<StatusDTO> listStatus(@RequestParam("statusIdList") List<String> statusIdList) {
        List<Long> sIdList = ListUtils.toLongList(statusIdList);
        return tweetService.listStatus(sIdList);
    }


    /**
     * 获取当前推文的子推文id
     *
     * @param statusId
     * @return
     */
    @GetMapping("/list/{statusId}/childId")
    public List<String> listStatusChildId(@PathVariable("statusId") String statusId) {
        Long sid = Long.valueOf(statusId);
        List<Long> longList = tweetService.listStatusChildId(sid);
        return ListUtils.toStringList(longList);
    }


}
