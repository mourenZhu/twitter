package cn.zhumouren.twitter.cloud.tweet.entity;

import cn.zhumouren.twitter.cloud.tweet.handler.mybatis.ListTypeHandler;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 推文表
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(autoResultMap = true)
public class Tweet implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 推文id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 用户唯一id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    /**
     * 推文内容
     */
    private String content;

    /**
     * 图片绝对路径
     */
    @TableField(typeHandler = ListTypeHandler.class)
    private List<String> pics;

    /**
     * 推文点赞数
     */
    private Integer numLikes;

    /**
     * 推文回复数
     */
    private Integer numReplies;

    /**
     * 推文引用数
     */
    private Integer numQuote;

    /**
     * 推文转发数
     */
    private Integer numForward;

    /**
     * 推文创建时间
     */
    private LocalDateTime created;

    /**
     * 推文更新时间
     */
    private LocalDateTime updated;

    /**
     * 是否删除，0是没有删除
     */
    @TableField(value = "is_deleted")
    private Boolean deleted;


}
