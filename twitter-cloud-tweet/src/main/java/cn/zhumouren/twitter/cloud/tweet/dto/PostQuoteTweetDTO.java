package cn.zhumouren.twitter.cloud.tweet.dto;

import lombok.Data;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/14 14:20
 * @Version 1.0
 **/
@Data
public class PostQuoteTweetDTO extends PostTweetDTO{

    private String quotedTweetId;
}
