package cn.zhumouren.twitter.cloud.tweet.mapper;

import cn.zhumouren.twitter.cloud.tweet.dto.StatusDTO;
import cn.zhumouren.twitter.cloud.tweet.entity.Tweet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 推文表 Mapper 接口
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Repository
public interface TweetMapper extends BaseMapper<Tweet> {

    /**
     * 删除推文（修改is_deleted字段）
     *
     * @param tweetId
     * @param uid
     * @return
     */
    boolean deletedTweet(@Param("tweet_id") Long tweetId, @Param("uid") Long uid);

    /**
     * 判断推文是否存在，可用于判断是否可以回复
     *
     * @param tweetId
     * @return
     */
    boolean isExistTweet(@Param("tweet_id") Long tweetId);

    /**
     * 获得当前推文和他的所有父推文
     *
     * @param tweetId
     * @return
     */
    List<Tweet> listParentTweet(@Param("tweetId") Long tweetId);

    /**
     * 获得该推文的回复
     *
     * @param page
     * @param tweetId
     * @return
     */
    IPage<Tweet> getChildTweetPage(Page<Tweet> page, @Param("tweetId") Long tweetId);

    /**
     * 增加推文回复
     *
     * @param tweetId
     * @return
     */
    boolean addReplyNums(@Param("tweetId") Long tweetId);

    /**
     * 减少推文回复
     *
     * @param tweetId
     * @return
     */
    boolean subReplyNums(@Param("tweetId") Long tweetId);

    /**
     * 获得用户发布的推文（不包括回复）
     *
     * @param page
     * @param userId
     * @return
     */
    IPage<Tweet> getUserTweetPage(Page<Tweet> page, @Param("userId") Long userId);

    /**
     * 获得用户发布的推文id
     *
     * @param userId
     * @return
     */
    List<String> listUserStatusId(@Param("userId") Long userId);

    /**
     * 获得用户的status（包括推文与回复）
     *
     * @param userId
     * @return
     */
    List<StatusDTO> listUserStatus(@Param("userId") Long userId);

    /**
     * 获取单个status
     *
     * @param statusId
     * @return
     */
    StatusDTO getStatus(@Param("statusId") Long statusId);

    /**
     * 获取 list status
     *
     * @param statusIdList
     * @return
     */
    List<StatusDTO> listStatus(@Param("statusIdList") List<Long> statusIdList);

}
