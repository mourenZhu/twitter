package cn.zhumouren.twitter.cloud.timeline.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author mourenZhu
 */
@FeignClient(name = "server-oauth2")
public interface ITweetService {
    /**
     * 获得用户的推文
     * @param uid
     * @return
     */
    @GetMapping()
    JSONObject getUserTweetList(Long uid);
}
