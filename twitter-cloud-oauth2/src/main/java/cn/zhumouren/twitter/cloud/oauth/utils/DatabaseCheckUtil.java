package cn.zhumouren.twitter.cloud.oauth.utils;

import cn.zhumouren.twitter.cloud.oauth.config.DatabaseRoleAndPermissionConfig;
import cn.zhumouren.twitter.cloud.oauth.entity.SysPermission;
import cn.zhumouren.twitter.cloud.oauth.entity.SysRole;
import cn.zhumouren.twitter.cloud.oauth.entity.SysRolePermission;
import cn.zhumouren.twitter.cloud.oauth.service.ISysPermissionService;
import cn.zhumouren.twitter.cloud.oauth.service.ISysRolePermissionService;
import cn.zhumouren.twitter.cloud.oauth.service.ISysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/12 10:07
 * @Version 1.0
 **/
@Component
@Slf4j
public class DatabaseCheckUtil implements InitializingBean {

    @Autowired
    private DatabaseRoleAndPermissionConfig databaseRoleAndPermissionConfig;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysPermissionService permissionService;

    @Autowired
    private ISysRolePermissionService rolePermissionService;

    public void start() {
        boolean b = checkPermission() && checkRole() && checkRolePermission();
        if (!b) {
            log.error("检查遇到bug，请马上排除！");
            System.exit(0);
        }
    }

    public boolean checkPermission() {
        log.info("开始检查permission表！");
        boolean b = true;
        List<SysPermission> sysPermissions = databaseRoleAndPermissionConfig.getSysPermissions();
        for (SysPermission sysPermission : sysPermissions) {
            SysPermission p = permissionService.getById(sysPermission.getId());
            if (p == null) {
                log.info("该权限不存在！\n" + sysPermission.toString() + "\n开始插入！");
                b &= permissionService.save(sysPermission);
            }
        }
        log.info("permission表检查完成！");
        return b;
    }

    public boolean checkRole() {
        log.info("开始检查role表！");
        boolean b = true;
        List<SysRole> sysRoles = databaseRoleAndPermissionConfig.getSysRoles();
        for (SysRole sysRole : sysRoles) {
            SysRole r = roleService.getById(sysRole.getId());
            if (r == null) {
                log.info("该角色不存在！\n" + sysRole.toString() + "\n开始插入！");
                b &= roleService.save(sysRole);
            }
        }
        log.info("role表检查完成！");
        return b;
    }

    public boolean checkRolePermission() {
        log.info("开始检查role_permission表！");
        boolean b = true;
        List<SysRolePermission> sysRolePermissions = databaseRoleAndPermissionConfig.getSysRolePermissions();
        for (SysRolePermission sysRolePermission : sysRolePermissions) {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("role_id", sysRolePermission.getRoleId());
            queryWrapper.eq("permission_id", sysRolePermission.getPermissionId());
            SysRolePermission rp = rolePermissionService.getOne(queryWrapper);
            if (rp == null) {
                log.info("该角色与权限对应关系不存在！\n" + sysRolePermission.toString() + "\n开始插入！");
                b &= rolePermissionService.save(sysRolePermission);
            }
        }
        log.info("role_permission表检查完成！");
        return b;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        start();
    }
}
