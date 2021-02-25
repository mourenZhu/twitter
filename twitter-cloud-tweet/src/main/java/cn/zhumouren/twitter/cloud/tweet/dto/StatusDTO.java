package cn.zhumouren.twitter.cloud.tweet.dto;

import cn.zhumouren.twitter.cloud.tweet.entity.Tweet;
import cn.zhumouren.twitter.cloud.tweet.ser.ToListStringSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.List;

/**
 * @Description 把推文或回复切割为一个对象，全部提取后交给timeline服务去处理
 * @Author mourenZhu
 * @Date 2021/2/19 16:27
 * @Version 1.0
 **/
@Data
public class StatusDTO extends Tweet {

    /**
     * 父推文id
     */
    @JsonSerialize(using = ToListStringSerializer.class)
    List<Long> parentTweetIds;


    /**
     * 推文回复的用户id
     */
    @JsonSerialize(using = ToListStringSerializer.class)
    List<Long> parentTweetUserIds;


}
