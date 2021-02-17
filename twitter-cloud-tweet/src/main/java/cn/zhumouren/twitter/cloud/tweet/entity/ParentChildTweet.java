package cn.zhumouren.twitter.cloud.tweet.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 推文闭包表
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ParentChildTweet implements Serializable {

    private static final long serialVersionUID = 1L;

    public ParentChildTweet(Long parentId, Long childId, Integer level, boolean root) {
        this.parentId = parentId;
        this.childId = childId;
        this.level = level;
        this.root = root;
    }

    /**
     * 父评论id
     */
    private Long parentId;

    /**
     * 子评论id
     */
    private Long childId;

    /**
     * 回复层级
     */
    private Integer level;

    /**
     * 是否为推文，1是推文，0是评论
     */
    @TableField(value = "is_root")
    private boolean root;

    /**
     * 是否删除，0是没有删除
     */
    @TableField(value = "is_deleted")
    private boolean deleted;


}
