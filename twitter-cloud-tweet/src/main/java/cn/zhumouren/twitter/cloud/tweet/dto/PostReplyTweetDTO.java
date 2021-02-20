package cn.zhumouren.twitter.cloud.tweet.dto;

import lombok.Data;

/**
 * @Description 前端回复推文对象
 * @Author mourenZhu
 * @Date 2021/2/16 17:06
 * @Version 1.0
 **/
@Data
public class PostReplyTweetDTO {

    private String parentId;
    private String replyContent;
    private String replyPics;
}
