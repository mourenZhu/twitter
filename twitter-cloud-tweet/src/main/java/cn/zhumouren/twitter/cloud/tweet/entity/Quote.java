package cn.zhumouren.twitter.cloud.tweet.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 推文引用表
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tweet_quote")
public class Quote implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 父推文id
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

    /**
     * 是否删除，0是没有删除
     */
    @TableField(value = "is_deleted")
    private boolean deleted;

}
