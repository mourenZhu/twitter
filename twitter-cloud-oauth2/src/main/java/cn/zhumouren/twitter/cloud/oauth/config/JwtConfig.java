package cn.zhumouren.twitter.cloud.oauth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/1/29 16:45
 * @Version 1.0
 **/
@Component
@Data
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    private String signingKey;

    private Map<String, Object> info;
}
