package cn.zhumouren.twitter.cloud.timeline.service.client;

import cn.zhumouren.twitter.cloud.constant.exception.TweetDeletedException;
import cn.zhumouren.twitter.cloud.constant.exception.TweetNotExistException;
import cn.zhumouren.twitter.cloud.timeline.domain.StatusJson;
import cn.zhumouren.twitter.cloud.timeline.service.client.impl.TweetServerTweetClientImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/24 21:48
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TweetServiceTest {

    @Autowired
    private ITweetServerTweetClient itweetClientTweetServer;

    @Autowired
    private TweetServerTweetClientImpl tweetService;

    @Test
    public void getStatusJsonTest() {
        try {
            StatusJson status = tweetService.getStatus(1362317196449124354L);
        } catch (TweetNotExistException | TweetDeletedException e) {
            e.printStackTrace();
        }
//        System.out.println("status object =================" + status.toString());
        JSONObject jsonObject = itweetClientTweetServer.getStatus("1362317196449124354");
        System.out.println("json object =================" + jsonObject.toJSONString());
        Object data = jsonObject.getObject("data", Object.class);
        System.out.println("data ============" + data);
    }

    @Test
    public void listUserStatusTest() {
        JSONObject jsonObject = itweetClientTweetServer.listUserStatus("1000000000000000001");
        List data = jsonObject.getObject("data", List.class);

        List<StatusJson> statusJsonList = JSON.parseArray(JSON.toJSONString(data), StatusJson.class);
        for (StatusJson statusJson : statusJsonList) {
            System.out.println(statusJson.toString());
        }
    }

    @Test
    public void listUserStatusIdTest() {
        List<Long> longList = tweetService.listUserStatusId(1000000000000000001L);
        for (Long l : longList) {
            System.out.println(l);
        }
    }
}
