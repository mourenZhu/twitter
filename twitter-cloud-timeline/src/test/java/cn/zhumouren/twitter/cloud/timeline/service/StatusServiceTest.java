package cn.zhumouren.twitter.cloud.timeline.service;

import cn.zhumouren.twitter.cloud.timeline.domain.StatusJson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/27 20:09
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class StatusServiceTest {

    @Autowired
    private IStatusService statusService;

    @Test
    public void puStatusTest() {
        StatusJson statusJson = statusService.getStatusJson(1364450317210509314L);
        statusService.pushStatus(statusJson);
    }

    @Test
    public void getStatusTest() {
        StatusJson statusJson = statusService.getStatusJson(1362317196449124354L);
        System.out.println(statusJson.toString());
    }

    @Test
    public void listStatusTest() {
        List<Long> list = new LinkedList<>();
        list.add(1361936840277454849L);
        list.add(1361937053947883522L);
        list.add(1361936996511084545L);
        list.add(1364474431245770753L);
        list.add(1362317196449124354L);
        List<StatusJson> statusJsonList = statusService.listStatusJson(list);
        for (StatusJson statusJson : statusJsonList) {
            System.out.println(statusJson.toString());
        }
    }
}
