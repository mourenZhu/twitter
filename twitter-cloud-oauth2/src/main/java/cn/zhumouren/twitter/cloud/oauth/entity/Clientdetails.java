package cn.zhumouren.twitter.cloud.oauth.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhumouren
 * @since 2021-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ClientDetails")
public class Clientdetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("appId")
    private String appid;

    @TableField("resourceIds")
    private String resourceids;

    @TableField("appSecret")
    private String appsecret;

    private String scope;

    @TableField("grantTypes")
    private String granttypes;

    @TableField("redirectUrl")
    private String redirecturl;

    private String authorities;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    @TableField("additionalInformation")
    private String additionalinformation;

    @TableField("autoApproveScopes")
    private String autoapprovescopes;


}
