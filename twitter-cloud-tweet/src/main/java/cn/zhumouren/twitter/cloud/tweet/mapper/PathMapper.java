package cn.zhumouren.twitter.cloud.tweet.mapper;

import cn.zhumouren.twitter.cloud.tweet.entity.Path;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 回复闭包路径表 Mapper 接口
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-09
 */
@Repository
public interface PathMapper extends BaseMapper<Path> {
    /**
     * 删除推文路径（修改is_deleted字段）
     *
     * @param childId
     * @return
     */
    boolean deletedTweetChildPath(@Param("childId") Long childId);
}
