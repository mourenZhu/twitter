package cn.zhumouren.twitter.cloud.tweet;

import cn.zhumouren.twitter.cloud.tweet.dto.StatusDTO;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/22 22:10
 * @Version 1.0
 **/
public class Test {

    @org.junit.Test
    public void test(){
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setId(123456L);
        System.out.println(statusDTO.getId());
    }

}
