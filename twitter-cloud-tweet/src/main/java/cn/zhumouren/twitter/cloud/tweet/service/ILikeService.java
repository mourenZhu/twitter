package cn.zhumouren.twitter.cloud.tweet.service;

import cn.zhumouren.twitter.cloud.constant.exception.LikeNotExistException;
import cn.zhumouren.twitter.cloud.constant.exception.NotInsertLikeException;
import cn.zhumouren.twitter.cloud.tweet.entity.Like;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 推文点赞表 服务类
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
public interface ILikeService extends IService<Like> {

    /**
     * 提交点赞
     *
     * @param tweetId
     * @param userId
     * @return
     * @throws NotInsertLikeException
     */
    boolean postLike(Long tweetId, Long userId) throws NotInsertLikeException;

    /**
     * 删除点赞
     *
     * @param tweetId
     * @param userId
     * @return
     * @throws LikeNotExistException
     */
    boolean deleteLike(Long tweetId, Long userId) throws LikeNotExistException;

    /**
     * 获取用户点赞的推文id
     *
     * @param userId
     * @return
     */
    List<Long> listUserLikeTweetId(Long userId);

}
