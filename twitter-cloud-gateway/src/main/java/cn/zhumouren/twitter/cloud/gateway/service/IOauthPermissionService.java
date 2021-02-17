package cn.zhumouren.twitter.cloud.gateway.service;

import cn.zhumouren.twitter.cloud.gateway.service.fallback.OauthPermissionServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author mourenZhu
 */
@FeignClient(name = "server-oauth2", fallback = OauthPermissionServiceFallback.class)
public interface IOauthPermissionService {

    @GetMapping("/permission/is")
    String getPermissionByPath(@RequestParam("path") String path);
}
