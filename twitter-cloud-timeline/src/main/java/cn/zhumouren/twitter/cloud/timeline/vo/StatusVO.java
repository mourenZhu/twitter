package cn.zhumouren.twitter.cloud.timeline.vo;

import cn.zhumouren.twitter.cloud.constant.ser.ToListStringSerializer;
import cn.zhumouren.twitter.cloud.timeline.domain.StatusJson;
import cn.zhumouren.twitter.cloud.timeline.domain.UserJson;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/28 1:56
 * @Version 1.0
 **/
@Data
public class StatusVO {

    /**
     * 父推文id
     */
    @JsonSerialize(using = ToListStringSerializer.class)
    private List<Long> parentTweetIds;
    /**
     * 推文回复的用户username
     */
    private List<String> parentUsernames;
    /**
     * 推文id
     */
    private Long id;
    /**
     * username
     */
    private String username;
    /**
     * nickname
     */
    private String nickname;
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

    public StatusVO() {
    }

    public StatusVO(StatusVO statusVO){
        this.parentTweetIds = statusVO.getParentTweetIds();
        this.parentUsernames = statusVO.parentUsernames;
        this.id = statusVO.getId();
        this.username = statusVO.getUsername();
        this.nickname = statusVO.getNickname();
        this.content = statusVO.getContent();
        this.pics = statusVO.getPics();
        this.numLikes = statusVO.getNumLikes();
        this.numReplies = statusVO.getNumReplies();
        this.numQuote = statusVO.getNumQuote();
        this.numForward = statusVO.getNumForward();
        this.created = statusVO.getCreated();
        this.updated = statusVO.getUpdated();
        this.deleted = statusVO.getDeleted();
    }

    public StatusVO(StatusJson statusJson, UserJson userJson, List<String> parentUsernames) {
        this.parentTweetIds = statusJson.getParentTweetIds();
        this.parentUsernames = parentUsernames;
        this.id = statusJson.getId();
        this.username = userJson.getUsername();
        this.nickname = userJson.getNickname();
        this.content = statusJson.getContent();
        this.pics = statusJson.getPics();
        this.numLikes = statusJson.getNumLikes();
        this.numReplies = statusJson.getNumReplies();
        this.numQuote = statusJson.getNumQuote();
        this.numForward = statusJson.getNumForward();
        this.created = statusJson.getCreated();
        this.updated = statusJson.getUpdated();
        this.deleted = statusJson.getDeleted();
    }

}
