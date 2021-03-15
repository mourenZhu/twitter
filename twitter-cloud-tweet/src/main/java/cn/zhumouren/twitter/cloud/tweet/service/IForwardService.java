package cn.zhumouren.twitter.cloud.tweet.service;

import cn.zhumouren.twitter.cloud.constant.exception.ForwardNotExistException;
import cn.zhumouren.twitter.cloud.constant.exception.NotInsertForwardException;
import cn.zhumouren.twitter.cloud.tweet.entity.Forward;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 推文转发表 服务类
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
public interface IForwardService extends IService<Forward> {

    /**
     * 提交转发
     *
     * @param tweetId
     * @param userId
     * @return
     * @throws NotInsertForwardException
     */
    boolean postForward(Long tweetId, Long userId) throws NotInsertForwardException;

    /**
     * 取消转发
     *
     * @param tweetId
     * @param userId
     * @return
     * @throws ForwardNotExistException
     */
    boolean deleteForward(Long tweetId, Long userId) throws ForwardNotExistException;

    /**
     * 获取转发对象
     *
     * @param userId
     * @return
     */
    List<Forward> listForwardByUser(Long userId);

    /**
     * 获取此推文的所有转发者id
     *
     * @param statusId
     * @return
     */
    List<Long> listForwardUserId(Long statusId);

}
