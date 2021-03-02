package cn.zhumouren.twitter.cloud.user.vo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/2 15:59
 * @Version 1.0
 **/
@Data
public class DetailUserVO {

    /**
     * 用户唯一id
     */
    private Long id;

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
