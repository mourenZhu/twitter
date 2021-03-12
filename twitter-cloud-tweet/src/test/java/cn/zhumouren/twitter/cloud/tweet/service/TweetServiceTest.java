package cn.zhumouren.twitter.cloud.tweet.service;

import cn.zhumouren.twitter.cloud.constant.utils.clazz.FieldUtils;
import cn.zhumouren.twitter.cloud.tweet.dto.ClickStatusDTO;
import cn.zhumouren.twitter.cloud.tweet.dto.StatusDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/12 20:41
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TweetServiceTest {

    @Autowired
    private ITweetService tweetService;

    @Test
    public void test() throws IllegalAccessException, NoSuchFieldException {
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setId(135464L);
        ClickStatusDTO clickStatusDTO = new ClickStatusDTO();
        FieldUtils.fatherValueCopyToSonValue(statusDTO, clickStatusDTO);
        System.out.println(clickStatusDTO.getId());
    }

    @Test
    public void listUserStatus() {
        List<StatusDTO> statusDTOS = tweetService.listUserStatus(1000000000000000101L);
        for (StatusDTO statusDTO : statusDTOS) {
            System.out.println(statusDTO.toString());
        }
    }

}
