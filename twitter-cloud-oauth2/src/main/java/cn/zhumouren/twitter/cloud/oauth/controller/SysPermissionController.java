package cn.zhumouren.twitter.cloud.oauth.controller;


import cn.zhumouren.twitter.cloud.oauth.entity.SysPermission;
import cn.zhumouren.twitter.cloud.oauth.service.ISysPermissionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author zhumouren
 * @since 2021-01-14
 */
@RestController
@RequestMapping("/permission")
public class SysPermissionController {

    @Autowired
    private ISysPermissionService permissionService;

    @GetMapping("/is")
    public String getUrlPermission(@RequestParam("url") String url) {
        return permissionService.getUrlPermission(url);
    }
}
