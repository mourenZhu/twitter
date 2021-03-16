package cn.zhumouren.twitter.cloud.timeline.service.client;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description 转发
 * @Author mourenZhu
 * @Date 2021/3/16 13:47
 * @Version 1.0
 **/
@FeignClient(name = "server-tweet")
public interface ITweetServerForwardClient {

    /**
     * 获取用户的转发
     *
     * @param userId
     * @return
     */
    @GetMapping("/{userId}/list/forward")
    JSONObject listUserForward(@PathVariable("userId") String userId);

    /**
     * 获取转发了该推文的用户id
     *
     * @param statusId
     * @return
     */
    @GetMapping("/status/{statusId}/forward/list/userId")
    JSONObject listForwardUserId(@PathVariable("statusId") String statusId);
}
