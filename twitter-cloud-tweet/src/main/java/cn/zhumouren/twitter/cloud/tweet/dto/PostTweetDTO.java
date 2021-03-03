package cn.zhumouren.twitter.cloud.tweet.dto;

import lombok.Data;

import java.util.List;

/**
 * @Description 前端传给后端的tweet对象
 * @Author mourenZhu
 * @Date 2021/2/16 15:06
 * @Version 1.0
 **/

@Data
public class PostTweetDTO {

    private String content;

    private List<String> pics;
}
