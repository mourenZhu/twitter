package cn.zhumouren.twitter.cloud.timeline.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mourenZhu
 */
@FeignClient(name = "server-tweet")
public interface ITweetService {

    /**
     * 获得用户发布推文的id
     *
     * @param uid
     * @return
     */
    @GetMapping("/{userId}/list/statusId")
    JSONObject listUserStatusId(@PathVariable("userId") String uid);

    /**
     * 获得用户的推文
     *
     * @param uid
     * @return
     */
    @GetMapping("/{userId}/list/status")
    JSONObject listUserStatus(@PathVariable("userId") String uid);
}
