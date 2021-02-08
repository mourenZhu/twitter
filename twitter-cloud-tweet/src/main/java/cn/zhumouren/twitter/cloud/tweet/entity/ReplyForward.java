package cn.zhumouren.twitter.cloud.tweet.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 回复转发表
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ReplyForward implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 推文id
     */
    private Long replyId;

    /**
     * 用户唯一id
     */
    private Long userId;

    /**
     * 引用创建时间
     */
    private LocalDateTime created;


}
