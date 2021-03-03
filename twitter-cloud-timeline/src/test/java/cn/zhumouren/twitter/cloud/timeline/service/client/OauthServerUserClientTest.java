package cn.zhumouren.twitter.cloud.timeline.service.client;

import cn.zhumouren.twitter.cloud.timeline.service.client.impl.OauthServerUserClientImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/3 22:44
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OauthServerUserClientTest {

    @Autowired
    private OauthServerUserClientImpl oauthServerUserClient;

    @Test
    public void getUsernameTest(){
        oauthServerUserClient.getUsername(100000000000000L);
    }

}
