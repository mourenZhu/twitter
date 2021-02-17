package cn.zhumouren.twitter.cloud.tweet.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 推文点赞表
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tweet_like")
public class Like implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 推文id
     */
    private Long tweetId;

    /**
     * 用户唯一id
     */
    private Long userId;

    /**
     * 点赞创建时间
     */
    private LocalDateTime created;

    /**
     * 是否删除，0是没有删除
     */
    @TableField(value = "is_deleted")
    private boolean deleted;

}
