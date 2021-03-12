package cn.zhumouren.twitter.cloud.oauth.config;

import cn.zhumouren.twitter.cloud.oauth.entity.SysPermission;
import cn.zhumouren.twitter.cloud.oauth.entity.SysRole;
import cn.zhumouren.twitter.cloud.oauth.entity.SysRolePermission;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description 用来读取系统所必须的权限配置
 * @Author mourenZhu
 * @Date 2021/3/12 8:18
 * @Version 1.0
 **/
@Component
@PropertySource(value = "classpath:config/databaseRoleAndPermission.properties", encoding = "UTF-8")
@ConfigurationProperties(prefix = "database")
@EnableConfigurationProperties({DatabaseRoleAndPermissionConfig.class})
public class DatabaseRoleAndPermissionConfig {

    private List<SysPermission> sysPermissions;

    private List<SysRole> sysRoles;

    private List<SysRolePermission> sysRolePermissions;

    public List<SysPermission> getSysPermissions() {
        return sysPermissions;
    }

    public void setSysPermissions(List<SysPermission> sysPermissions) {
        this.sysPermissions = sysPermissions;
    }

    public List<SysRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(List<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    public List<SysRolePermission> getSysRolePermissions() {
        return sysRolePermissions;
    }

    public void setSysRolePermissions(List<SysRolePermission> sysRolePermissions) {
        this.sysRolePermissions = sysRolePermissions;
    }
}
