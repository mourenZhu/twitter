package cn.zhumouren.twitter.cloud.tweet.mapper;

import cn.zhumouren.twitter.cloud.tweet.entity.Forward;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 推文转发表 Mapper 接口
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Repository
public interface ForwardMapper extends BaseMapper<Forward> {

    /**
     * 插入转发记录
     *
     * @param tweetId
     * @param userId
     * @return
     */
    boolean insertForward(@Param("tweetId") Long tweetId, @Param("userId") Long userId);

    /**
     * 取消转发，并不是真的删除数据
     *
     * @param tweetId
     * @param userId
     * @return
     */
    int deleteForward(@Param("tweetId") Long tweetId, @Param("userId") Long userId);

    /**
     * 获取forward对象
     *
     * @param userId
     * @return
     */
    List<Forward> listForwardByUser(@Param("userId") Long userId);

}
