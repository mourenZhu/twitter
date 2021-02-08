package cn.zhumouren.twitter.cloud.tweet.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 回复闭包路径表
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ReplyPath implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 父评论id
     */
    private Long parentId;

    /**
     * 子评论id
     */
    private Long childId;


}
