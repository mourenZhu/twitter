package cn.zhumouren.twitter.cloud.tweet.service.impl;

import cn.zhumouren.twitter.cloud.tweet.entity.ReplyPath;
import cn.zhumouren.twitter.cloud.tweet.mapper.ReplyPathMapper;
import cn.zhumouren.twitter.cloud.tweet.service.IReplyPathService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 回复闭包路径表 服务实现类
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Service
public class ReplyPathServiceImpl extends ServiceImpl<ReplyPathMapper, ReplyPath> implements IReplyPathService {

}
