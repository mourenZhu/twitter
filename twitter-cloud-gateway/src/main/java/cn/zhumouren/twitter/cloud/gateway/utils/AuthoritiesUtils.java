package cn.zhumouren.twitter.cloud.gateway.utils;

import cn.zhumouren.twitter.cloud.gateway.config.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author mourenZhu
 */
@Component
@PropertySource("classpath:config/yml.yml")
public class AuthoritiesUtils {

    private static String signingKey;

    @Autowired
    private JwtConfig jwtConfig;

    @Value("${jwt.signingKey}")
    public void setSigningKey(String key){
        signingKey = key;
    }


    public static boolean isSignature(String token) {

        try {
            Jwt jwt = JwtHelper.decode(token);
            jwt.verifySignature(new MacSigner(signingKey));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isAuthorities(String token, String permission) {
        Jwt jwt = JwtHelper.decode(token);
        ArrayList<String> jwtList = JwtUtils.getAuthorities(jwt);
        for (String s : jwtList) {
            if (s.equals(permission)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExp(String token) {
        Jwt jwt = JwtHelper.decode(token);
        Long nowTime = System.currentTimeMillis() / 1000;
        Integer jwtTime = JwtUtils.getInteger(jwt, "exp");
        if (nowTime < jwtTime){
            return true;
        }
        return false;
    }
}
