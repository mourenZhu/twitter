package cn.zhumouren.twitter.cloud.tweet.service.impl;

import cn.zhumouren.twitter.cloud.tweet.entity.ParentChildTweet;
import cn.zhumouren.twitter.cloud.tweet.mapper.ParentChildTweetMapper;
import cn.zhumouren.twitter.cloud.tweet.service.IParentChildTweetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 推文闭包表 服务实现类
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-17
 */
@Service
public class ParentChildTweetServiceImpl extends ServiceImpl<ParentChildTweetMapper, ParentChildTweet> implements IParentChildTweetService {

}
