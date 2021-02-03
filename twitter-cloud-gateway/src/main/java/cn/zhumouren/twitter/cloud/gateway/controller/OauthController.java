package cn.zhumouren.twitter.cloud.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
public class OauthController {

    @GetMapping("/code")
    public String code(@RequestParam("code") String code) {
        return "code=" + code;
    }
}
