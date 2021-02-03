package cn.zhumouren.twitter.cloud.oauth.mapper;

import cn.zhumouren.twitter.cloud.oauth.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author zhumouren
 * @since 2021-01-14
 */
@Repository
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    List<SysPermission> selectByUsername(String username);
}
