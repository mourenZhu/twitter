package cn.zhumouren.twitter.cloud.tweet.vo;

import lombok.Data;

/**
 * @Description 前端传给后端的tweet对象
 * @Author mourenZhu
 * @Date 2021/2/16 15:06
 * @Version 1.0
 **/

@Data
public class PostTweetVO {

    private String content;

    private String pics;
}
