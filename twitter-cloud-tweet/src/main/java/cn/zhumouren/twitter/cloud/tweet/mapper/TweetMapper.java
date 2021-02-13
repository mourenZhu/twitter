package cn.zhumouren.twitter.cloud.tweet.mapper;

import cn.zhumouren.twitter.cloud.tweet.entity.Tweet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
     * @param tweetId
     * @param uid
     * @return
     */
    boolean deletedTweet(@Param("tweet_id") Long tweetId, @Param("uid") Long uid);


    List<Tweet> listParentTweet();

}
