package cn.zhumouren.twitter.cloud.timeline.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author mourenZhu
 */
@FeignClient(name = "server-oauth2")
public interface IOauthServerUserClient {

    /**
     * 获取username
     *
     * @param uid
     * @return
     */
    @GetMapping("/user/username")
    String getUsername(@RequestParam("uid") String uid);
}
