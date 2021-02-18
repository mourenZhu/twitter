package cn.zhumouren.twitter.cloud.tweet.mapper;

import cn.zhumouren.twitter.cloud.tweet.entity.ParentChildTweet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 推文闭包表 Mapper 接口
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-17
 */
@Repository
public interface ParentChildTweetMapper extends BaseMapper<ParentChildTweet> {

    /**
     * 删除推文路径（修改is_deleted字段）
     *
     * @param childId
     * @return
     */
    boolean deletedTweet(@Param("childId") Long childId);

    /**
     * 用close table 的方式存储推文回复
     *
     * @param parentId
     * @param childId
     * @return
     */
    boolean postTweetReply(@Param("parentId") Long parentId, @Param("childId") Long childId);

    /**
     * 通过子id和评论等级获得父id
     *
     * @param childId
     * @param level
     * @return
     */
    Long getParentId(@Param("childId") Long childId, @Param("level") Integer level);

}
