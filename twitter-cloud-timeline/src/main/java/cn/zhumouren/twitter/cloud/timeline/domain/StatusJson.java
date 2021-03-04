package cn.zhumouren.twitter.cloud.timeline.domain;

import cn.zhumouren.twitter.cloud.constant.ser.ToListStringSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description status json
 * @Author mourenZhu
 * @Date 2021/2/24 22:03
 * @Version 1.0
 **/
@Data
public class StatusJson {

    /**
     * 父推文id
     */
    @JsonSerialize(using = ToListStringSerializer.class)
    private List<Long> parentTweetIds;

    /**
     * 推文回复的用户id
     */
    @JsonSerialize(using = ToListStringSerializer.class)
    private List<Long> parentTweetUserIds;

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
    private Boolean deleted;
}
