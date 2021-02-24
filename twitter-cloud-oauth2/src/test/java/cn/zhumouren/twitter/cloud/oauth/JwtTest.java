package cn.zhumouren.twitter.cloud.oauth;

import cn.zhumouren.twitter.cloud.oauth.config.JwtConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/24 1:14
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTest {

    @Autowired
    private JwtConfig jwtConfig;

    @Test
    public void jwtTest(){
        System.out.println("xx===" + jwtConfig.getSigningKey());
    }
}
