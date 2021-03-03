package cn.zhumouren.twitter.cloud.oauth.mapper;

import cn.zhumouren.twitter.cloud.oauth.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author zhumouren
 * @since 2021-01-14
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 获取username
     *
     * @param uid
     * @return
     */
    String getUsername(@Param("uid") Long uid);

}
