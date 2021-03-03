package cn.zhumouren.twitter.cloud.oauth.controller;


import cn.zhumouren.twitter.cloud.oauth.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zhumouren
 * @since 2021-01-14
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private ISysUserService userService;

    @GetMapping("/username")
    public String getUsername(@RequestParam("uid") String uid){
        return userService.getUsername(Long.valueOf(uid));
    }

}
