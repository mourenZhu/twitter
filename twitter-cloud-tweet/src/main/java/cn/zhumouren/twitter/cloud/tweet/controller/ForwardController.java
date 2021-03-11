package cn.zhumouren.twitter.cloud.tweet.controller;


import cn.zhumouren.twitter.cloud.constant.exception.ForwardNotExistException;
import cn.zhumouren.twitter.cloud.constant.exception.TweetNotExistOrDeletedException;
import cn.zhumouren.twitter.cloud.constant.result.annotation.ResponseResultBody;
import cn.zhumouren.twitter.cloud.constant.utils.jwt.JwtUtils;
import cn.zhumouren.twitter.cloud.tweet.service.IForwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 推文转发表 前端控制器
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@RestController
@RequestMapping("/tweet")
@ResponseResultBody
public class ForwardController {

    @Autowired
    private IForwardService forwardService;

    /**
     * 转发推文
     *
     * @param tweetId
     * @param accessToken
     * @return
     */
    @PostMapping("/forward")
    public boolean postForward(@RequestParam("tweetId") String tweetId,
                               @RequestHeader("access_token") String accessToken) throws TweetNotExistOrDeletedException {
        Long tId = Long.valueOf(tweetId);
        Long userId = JwtUtils.getLongByString(accessToken, "uid");
        return forwardService.postForward(tId, userId);
    }

    /**
     * 取消转发
     *
     * @param tweetId
     * @param accessToken
     * @return
     */
    @DeleteMapping("/forward")
    public boolean deleteForward(@RequestParam("tweetId") String tweetId,
                                 @RequestHeader("access_token") String accessToken) throws ForwardNotExistException {
        Long tId = Long.valueOf(tweetId);
        Long userId = JwtUtils.getLongByString(accessToken, "uid");
        return forwardService.deleteForward(tId, userId);
    }
}
