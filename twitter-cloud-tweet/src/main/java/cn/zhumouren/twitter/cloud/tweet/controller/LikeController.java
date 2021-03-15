package cn.zhumouren.twitter.cloud.tweet.controller;


import cn.zhumouren.twitter.cloud.constant.exception.LikeNotExistException;
import cn.zhumouren.twitter.cloud.constant.exception.NotInsertLikeException;
import cn.zhumouren.twitter.cloud.constant.result.annotation.ResponseResultBody;
import cn.zhumouren.twitter.cloud.constant.utils.jwt.JwtUtils;
import cn.zhumouren.twitter.cloud.tweet.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 推文点赞表 前端控制器
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@RestController
@RequestMapping
@ResponseResultBody
public class LikeController {

    @Autowired
    private ILikeService likeService;

    /**
     * 提交点赞
     *
     * @param tweetId
     * @param accessToken
     * @return
     * @throws NotInsertLikeException
     */
    @PostMapping("/tweet/like")
    public boolean postLike(@RequestParam("tweetId") String tweetId,
                            @RequestHeader("access_token") String accessToken) throws NotInsertLikeException {
        Long tId = Long.valueOf(tweetId);
        Long userId = JwtUtils.getLongByString(accessToken, "uid");
        return likeService.postLike(tId, userId);
    }

    /**
     * 删除点赞
     *
     * @param tweetId
     * @param accessToken
     * @return
     * @throws LikeNotExistException
     */
    @DeleteMapping("/tweet/like")
    public boolean deleteLike(@RequestParam("tweetId") String tweetId,
                              @RequestHeader("access_token") String accessToken) throws LikeNotExistException {
        Long tId = Long.valueOf(tweetId);
        Long userId = JwtUtils.getLongByString(accessToken, "uid");
        return likeService.deleteLike(tId, userId);
    }

    /**
     * 获取用户点赞的推文id
     *
     * @param userId
     * @return
     */
    @GetMapping("/{userId}/likes")
    public List<String> listUserLikeTweetId(@PathVariable("userId") String userId) {
        Long uId = Long.valueOf(userId);
        List<Long> longList = likeService.listUserLikeTweetId(uId);
        return longList.stream().map(x -> x + "").collect(Collectors.toList());
    }

}
