package cn.zhumouren.twitter.cloud.tweet.controller;


import cn.zhumouren.twitter.cloud.constant.exception.ForwardNotExistException;
import cn.zhumouren.twitter.cloud.constant.exception.NotInsertForwardException;
import cn.zhumouren.twitter.cloud.constant.result.annotation.ResponseResultBody;
import cn.zhumouren.twitter.cloud.constant.utils.jwt.JwtUtils;
import cn.zhumouren.twitter.cloud.constant.utils.list.ListUtils;
import cn.zhumouren.twitter.cloud.tweet.entity.Forward;
import cn.zhumouren.twitter.cloud.tweet.service.IForwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 推文转发表 前端控制器
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@RestController
@RequestMapping
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
    @PostMapping("/tweet/forward")
    public boolean postForward(@RequestParam("tweetId") String tweetId,
                               @RequestHeader("access_token") String accessToken) throws NotInsertForwardException {
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
    @DeleteMapping("/tweet/forward")
    public boolean deleteForward(@RequestParam("tweetId") String tweetId,
                                 @RequestHeader("access_token") String accessToken) throws ForwardNotExistException {
        Long tId = Long.valueOf(tweetId);
        Long userId = JwtUtils.getLongByString(accessToken, "uid");
        return forwardService.deleteForward(tId, userId);
    }

    /**
     * 获取用户的转发
     *
     * @param userId
     * @return
     */
    @GetMapping("/{userId}/list/forward")
    public List<Forward> listUserForward(@PathVariable("userId") String userId) {
        Long uid = Long.valueOf(userId);
        return forwardService.listForwardByUser(uid);
    }

    /**
     * 获取转发了该推文的用户id
     *
     * @param statusId
     * @return
     */
    @GetMapping("/status/{statusId}/forward/list/userId")
    public List<String> listForwardUserId(@PathVariable("statusId") String statusId) {
        Long sId = Long.valueOf(statusId);
        return ListUtils.toStringList(forwardService.listForwardUserId(sId));
    }
}
