package cn.zhumouren.twitter.cloud.oauth.service;

import cn.zhumouren.twitter.cloud.oauth.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author zhumouren
 * @since 2021-01-14
 */
public interface ISysPermissionService extends IService<SysPermission> {

    List<SysPermission> selectByUsername(String username);
}
