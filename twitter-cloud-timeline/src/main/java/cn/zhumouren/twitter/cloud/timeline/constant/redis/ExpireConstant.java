package cn.zhumouren.twitter.cloud.timeline.constant.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/5 20:49
 * @Version 1.0
 **/
@Component
@PropertySource("classpath:config/redis.properties")
@ConfigurationProperties(prefix = "redis.expire")
@EnableConfigurationProperties({ExpireConstant.class})
public class ExpireConstant {

    private Long statusTime;

    private Long userTime;

    private Long timelineTime;

    private Long postsTime;

    @Override
    public String toString() {
        return "ExpireConstant{" +
                "statusTime=" + statusTime +
                ", userTime=" + userTime +
                ", timelineTime=" + timelineTime +
                ", postsTime=" + postsTime +
                '}';
    }

    public Long getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(Long statusTime) {
        this.statusTime = statusTime;
    }

    public Long getUserTime() {
        return userTime;
    }

    public void setUserTime(Long userTime) {
        this.userTime = userTime;
    }

    public Long getTimelineTime() {
        return timelineTime;
    }

    public void setTimelineTime(Long timelineTime) {
        this.timelineTime = timelineTime;
    }

    public Long getPostsTime() {
        return postsTime;
    }

    public void setPostsTime(Long postsTime) {
        this.postsTime = postsTime;
    }
}
