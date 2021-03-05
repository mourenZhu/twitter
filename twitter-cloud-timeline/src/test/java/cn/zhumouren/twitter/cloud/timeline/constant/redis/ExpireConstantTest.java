package cn.zhumouren.twitter.cloud.timeline.constant.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/5 21:05
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpireConstantTest {

    @Autowired
    private ExpireConstant expireConstant;

    @Test
    public void test(){
        System.out.println(expireConstant.toString());
    }
}
