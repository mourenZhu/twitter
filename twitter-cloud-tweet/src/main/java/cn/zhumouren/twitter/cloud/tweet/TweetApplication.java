package cn.zhumouren.twitter.cloud.tweet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/16 14:56
 * @Version 1.0
 **/

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("cn.zhumouren.twitter.cloud.tweet.mapper")
public class TweetApplication {
    public static void main(String[] args) {
        SpringApplication.run(TweetApplication.class, args);
    }
}
