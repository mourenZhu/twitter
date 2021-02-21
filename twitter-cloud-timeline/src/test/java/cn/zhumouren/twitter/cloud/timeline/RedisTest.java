package cn.zhumouren.twitter.cloud.timeline;

import cn.zhumouren.twitter.cloud.timeline.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/21 20:23
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test1(){
        System.out.println("hello, test!");
        redisUtil.hset("user:1000", "username", "zhumouren");
        redisUtil.hset("user:1000", "password", "123456");
        System.out.println(redisUtil.hget("user:1000", "username"));
        System.out.println(redisUtil.hget("user:1000", "password"));
        redisUtil.hmget("user:1000").toString();
    }

}
