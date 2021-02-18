package cn.zhumouren.twitter.cloud.timeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/18 14:31
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class TimelineApplication {
    public static void main(String[] args) {
        SpringApplication.run(TimelineApplication.class, args);
    }
}
