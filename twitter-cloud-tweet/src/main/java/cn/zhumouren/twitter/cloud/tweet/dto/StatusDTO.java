package cn.zhumouren.twitter.cloud.tweet.dto;

import cn.zhumouren.twitter.cloud.tweet.entity.Tweet;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;
import java.util.Stack;

/**
 * @Description 把推文或回复切割为一个对象，全部提取后交给timeline服务去处理
 * @Author mourenZhu
 * @Date 2021/2/19 16:27
 * @Version 1.0
 **/
@Data
public class StatusDTO extends Tweet {

    /**
     * 根推文id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long rootParentTweetId;


//    List<String> parentTweetUserIdList;

    /**
     * 推文回复的用户id
     */
    Stack<String> parentTweetUserIds;


}
