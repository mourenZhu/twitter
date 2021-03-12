package cn.zhumouren.twitter.cloud.oauth.config;

import cn.zhumouren.twitter.cloud.oauth.entity.SysPermission;
import cn.zhumouren.twitter.cloud.oauth.entity.SysRole;
import cn.zhumouren.twitter.cloud.oauth.entity.SysRolePermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/12 9:02
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseRoleAndPermissionConfigTest {

    @Autowired
    private DatabaseRoleAndPermissionConfig databaseRoleAndPermissionConfig;

    @Test
    public void getTest() {
        List<SysPermission> sysPermissions = databaseRoleAndPermissionConfig.getSysPermissions();
        System.out.println("以下是所有权限");
        for (SysPermission sysPermission : sysPermissions) {
            System.out.println(sysPermission.toString());
        }

        List<SysRole> sysRoles = databaseRoleAndPermissionConfig.getSysRoles();
        System.out.println("以下是所有角色");
        for (SysRole sysRole : sysRoles) {
            System.out.println(sysRole.toString());
        }

        List<SysRolePermission> sysRolePermissions = databaseRoleAndPermissionConfig.getSysRolePermissions();
        System.out.println("以下是角色与权限对应关系");
        for (SysRolePermission sysRolePermission : sysRolePermissions) {
            System.out.println(sysRolePermission.toString());
        }

    }
}
