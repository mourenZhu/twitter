package cn.zhumouren.twitter.cloud.tweet.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 回复闭包路径表
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tweet_path")
public class Path implements Serializable {

    public Path(Long parentId, Long childId) {
        this.parentId = parentId;
        this.childId = childId;
    }

    private static final long serialVersionUID = 1L;

    /**
     * 父评论id
     */
    private Long parentId;

    /**
     * 子评论id
     */
    private Long childId;

    /**
     * 是否删除，0是没有删除
     */
    @TableField(value = "is_deleted")
    private Integer deleted;


}
