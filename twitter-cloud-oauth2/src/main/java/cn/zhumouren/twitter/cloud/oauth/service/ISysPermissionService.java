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

    /**
     * 通过username获取用户的权限
     * @param username
     * @return
     */
    List<SysPermission> selectByUsername(String username);

    /**
     * 获取访问路径所需要的权限
     * @param url
     * @return
     */
    String getUrlPermission(String url);
}
