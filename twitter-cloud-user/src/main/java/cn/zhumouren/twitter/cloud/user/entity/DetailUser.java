package cn.zhumouren.twitter.cloud.user.entity;

import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户细节表
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DetailUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像路径
     */
    private String photo;

    /**
     * 用户顶部展示照片路径
     */
    private String headerPhoto;

    /**
     * 用户简介
     */
    private String about;

    /**
     * 用户网站
     */
    private String website;

    /**
     * 用户地址
     */
    private String location;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 关注数量
     */
    private Integer following;

    /**
     * 粉丝数量
     */
    private Integer follows;


}
