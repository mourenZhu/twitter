package cn.zhumouren.twitter.cloud.user.mapper;

import cn.zhumouren.twitter.cloud.user.entity.DetailUser;
import cn.zhumouren.twitter.cloud.user.vo.DetailUserVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户细节表 Mapper 接口
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Repository
public interface DetailUserMapper extends BaseMapper<DetailUser> {

    /**
     * 获取展示层user对象
     * @param uid
     * @return
     */
    DetailUserVO getDetailUserVO(@Param("uid") Long uid);

    /**
     * 更新用户详细信息
     * @param detailUserVO
     * @return
     */
    boolean updateDetailUser(@Param("duVO") DetailUserVO detailUserVO);

}
