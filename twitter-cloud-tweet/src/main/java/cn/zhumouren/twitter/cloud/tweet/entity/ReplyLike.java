package cn.zhumouren.twitter.cloud.tweet.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 回复点赞表
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ReplyLike implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 回复id
     */
    private Long replyId;

    /**
     * 用户唯一id
     */
    private Long userId;

    /**
     * 点赞创建时间
     */
    private LocalDateTime created;


}
