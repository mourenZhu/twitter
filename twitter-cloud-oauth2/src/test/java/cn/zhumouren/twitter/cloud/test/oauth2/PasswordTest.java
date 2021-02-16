package cn.zhumouren.twitter.cloud.test.oauth2;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.jwt.Jwt;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/10 15:24
 * @Version 1.0
 **/

public class PasswordTest {

    @Test
    public void createdPassword(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123456"));
    }

    public void jwtTest(){

    }

}
