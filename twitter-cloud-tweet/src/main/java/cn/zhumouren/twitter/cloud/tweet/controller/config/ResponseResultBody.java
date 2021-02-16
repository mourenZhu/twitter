package cn.zhumouren.twitter.cloud.tweet.controller.config;

import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * @Description 用于统一返回的json格式
 * @Author mourenZhu
 * @Date 2021/2/16 16:20
 * @Version 1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ResponseBody
public @interface ResponseResultBody {

}
