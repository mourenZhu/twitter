package cn.zhumouren.twitter.cloud.tweet.vo;

import cn.zhumouren.twitter.cloud.tweet.entity.Tweet;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.List;

/**
 * @Description 在前端页面需要展示的对象
 * @Author mourenZhu
 * @Date 2021/2/9 23:11
 * @Version 1.0
 **/
@Data
public class TweetLinkVO {

    private List<Tweet> parentTweetList;

    private Tweet currentTweet;

    private IPage<Tweet> childTweetPage;
}
