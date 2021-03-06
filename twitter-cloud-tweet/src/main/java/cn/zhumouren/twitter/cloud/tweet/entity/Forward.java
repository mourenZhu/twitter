package cn.zhumouren.twitter.cloud.tweet.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 推文转发表
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tweet_forward")
public class Forward implements Serializable {

    private static final long serialVersionUID = 1L;

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
    @TableField(value = "is_deleted")
    private boolean deleted;

}
