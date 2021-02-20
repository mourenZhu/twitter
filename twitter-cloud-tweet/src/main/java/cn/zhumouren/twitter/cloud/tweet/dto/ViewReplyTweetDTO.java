package cn.zhumouren.twitter.cloud.tweet.dto;

import cn.zhumouren.twitter.cloud.tweet.entity.Tweet;
import lombok.Data;

import java.util.List;

/**
 * @Description 把回复切割为一个对象，全部提取后交给timeline服务去处理
 * @Author mourenZhu
 * @Date 2021/2/19 16:27
 * @Version 1.0
 **/
@Data
public class ViewReplyTweetDTO {

    List<String> parentTweetUserIdList;

    Tweet tweet;

}
