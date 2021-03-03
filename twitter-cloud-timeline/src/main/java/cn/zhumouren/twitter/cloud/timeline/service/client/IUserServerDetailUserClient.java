package cn.zhumouren.twitter.cloud.timeline.service.client;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mourenZhu
 */
@FeignClient(name = "server-user")
public interface IUserServerDetailUserClient {

    /**
     * 通过userId获取用户详细信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/user/{userId}")
    JSONObject getDetailUserJson(@PathVariable("userId") String userId);
}
