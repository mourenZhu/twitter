package cn.zhumouren.twitter.cloud.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/21 16:18
 * @Version 1.0
 **/
@Component
@PropertySource("classpath:config/jwt.properties")
@ConfigurationProperties(prefix = "jwt")
@EnableConfigurationProperties({JwtConfig.class})
public class JwtConfig {

    private String signingKey;

    private Map<String, Object> info;

    public String getSigningKey() {
        return signingKey;
    }

    public void setSigningKey(String signingKey) {
        this.signingKey = signingKey;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }
}
