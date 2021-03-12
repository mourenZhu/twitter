package cn.zhumouren.twitter.cloud.oauth.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/12 10:39
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseCheckUtilTest {

    @Autowired
    private DatabaseCheckUtil databaseCheckUtil;

    @Test
    public void startTest(){
        databaseCheckUtil.start();
    }
}
