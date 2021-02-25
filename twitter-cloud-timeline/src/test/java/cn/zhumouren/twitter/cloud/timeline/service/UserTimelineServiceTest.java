package cn.zhumouren.twitter.cloud.timeline.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/25 22:43
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTimelineServiceTest {

    @Autowired
    private IUserTimelineService userTimelineService;

    @Test
    public void creatUserTimelineTest(){
        Long uid = 1000000000000000001L;
        System.out.println(userTimelineService.creatUserTimeline(uid));
    }
}
