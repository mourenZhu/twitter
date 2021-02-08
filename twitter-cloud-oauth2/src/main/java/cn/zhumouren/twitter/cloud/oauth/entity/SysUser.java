package cn.zhumouren.twitter.cloud.oauth.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author zhumouren
 * @since 2021-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户雪花id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码，加密存储
     */
    private String password;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 注册邮箱
     */
    private String email;

    /**
     * 账号是否过期
     */
    private Boolean accountNonExpired;

    /**
     * 账号是否锁定
     */
    private Boolean accountNonLocked;

    /**
     * 凭证是否过期
     */
    private Boolean credentialsNonExpired;

    private Boolean enabled;

    private LocalDateTime created;

    private LocalDateTime updated;


}
