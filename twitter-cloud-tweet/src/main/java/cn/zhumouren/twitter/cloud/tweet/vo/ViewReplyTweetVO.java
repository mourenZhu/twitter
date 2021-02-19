package cn.zhumouren.twitter.cloud.tweet.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/19 16:27
 * @Version 1.0
 **/
@Data
public class ViewReplyTweetVO {
    List<String> parentTweetUserIdList;
}
