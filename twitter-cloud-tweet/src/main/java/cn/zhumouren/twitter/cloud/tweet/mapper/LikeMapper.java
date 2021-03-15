package cn.zhumouren.twitter.cloud.tweet.mapper;

import cn.zhumouren.twitter.cloud.tweet.entity.Like;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 推文点赞表 Mapper 接口
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Repository
public interface LikeMapper extends BaseMapper<Like> {

    /**
     * 插入转发记录
     *
     * @param tweetId
     * @param userId
     * @return
     */
    boolean insertLike(@Param("tweetId") Long tweetId, @Param("userId") Long userId);

    /**
     * 取消转发，并不是真的删除数据
     *
     * @param tweetId
     * @param userId
     * @return
     */
    int deleteLike(@Param("tweetId") Long tweetId, @Param("userId") Long userId);

    /**
     * 获取用户的点赞推文id
     *
     * @param userId
     * @return
     */
    List<Long> listUserLikeTweetId(@Param("userId") Long userId);

}
