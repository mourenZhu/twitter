package cn.zhumouren.twitter.cloud.gateway.utils;

import cn.zhumouren.twitter.cloud.gateway.config.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author mourenZhu
 */
@Component
public class AuthoritiesUtils {


    private static JwtConfig jwtConfig;

    @Autowired
    public AuthoritiesUtils(JwtConfig jwtConfig) {
        AuthoritiesUtils.jwtConfig = jwtConfig;
    }


    public static boolean isSignature(String token) {

        try {
            Jwt jwt = JwtHelper.decode(token);
            jwt.verifySignature(new MacSigner(jwtConfig.getSigningKey()));
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
        return nowTime < jwtTime;
    }
}
