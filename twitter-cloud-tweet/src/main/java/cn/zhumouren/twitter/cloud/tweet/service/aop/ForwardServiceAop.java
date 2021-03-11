package cn.zhumouren.twitter.cloud.tweet.service.aop;

import cn.zhumouren.twitter.cloud.tweet.mapper.TweetMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/11 20:47
 * @Version 1.0
 **/
@Component
@Aspect
public class ForwardServiceAop {

    @Autowired
    private TweetMapper tweetMapper;

//    @Around(value = "execution( boolean cn.zhumouren.twitter.cloud.tweet.service.IForwardService.postForward(Long, Long))")
//    public Object postForwardAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        boolean proceed = (boolean) proceedingJoinPoint.proceed();
//
//
//        return false;
//    }
}
