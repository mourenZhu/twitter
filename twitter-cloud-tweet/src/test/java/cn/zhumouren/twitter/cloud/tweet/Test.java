package cn.zhumouren.twitter.cloud.tweet;

import cn.zhumouren.twitter.cloud.tweet.dto.ViewReplyTweetDTO;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/22 22:10
 * @Version 1.0
 **/
public class Test {

    @org.junit.Test
    public void test(){
        ViewReplyTweetDTO viewReplyTweetDTO = new ViewReplyTweetDTO();
        viewReplyTweetDTO.setId(123456L);
        System.out.println(viewReplyTweetDTO.getId());
    }

}
