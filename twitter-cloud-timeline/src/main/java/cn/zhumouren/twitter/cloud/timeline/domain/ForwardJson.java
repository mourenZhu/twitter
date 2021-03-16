package cn.zhumouren.twitter.cloud.timeline.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description 转发对象
 * @Author mourenZhu
 * @Date 2021/3/16 13:43
 * @Version 1.0
 **/
@Data
public class ForwardJson {

    /**
     * 推文id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long tweetId;

    /**
     * 用户唯一id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    /**
     * 转发创建时间
     */
    private LocalDateTime created;

    /**
     * 转发更新时间
     */
    private LocalDateTime updated;

    /**
     * 是否删除，0是没有删除
     */
    private boolean deleted;
}
