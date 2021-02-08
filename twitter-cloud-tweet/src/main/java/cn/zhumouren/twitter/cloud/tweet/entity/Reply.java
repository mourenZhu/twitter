package cn.zhumouren.twitter.cloud.tweet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 推文回复表
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tweet_reply")
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 父推文id
     */
    private Long tweetId;

    /**
     * 用户唯一id
     */
    private Long userId;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 图片绝对路径
     */
    private String pics;

    /**
     * 回复点赞数
     */
    private Integer numLikes;

    /**
     * 回复回复数
     */
    private Integer numReplies;

    /**
     * 回复引用数
     */
    private Integer numQuote;

    /**
     * 回复转发数
     */
    private Integer numForward;

    /**
     * 回复创建时间
     */
    private LocalDateTime created;

    /**
     * 回复更新时间
     */
    private LocalDateTime updated;


}
