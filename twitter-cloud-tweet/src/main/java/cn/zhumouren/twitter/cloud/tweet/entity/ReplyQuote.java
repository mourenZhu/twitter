package cn.zhumouren.twitter.cloud.tweet.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 回复引用表
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ReplyQuote implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 父回复id
     */
    private Long parentId;

    /**
     * 子推文id
     */
    private Long childId;

    /**
     * 用户唯一id
     */
    private Long userId;

    /**
     * 引用创建时间
     */
    private LocalDateTime created;


}
