package cn.zhumouren.twitter.cloud.tweet.service.impl;

import cn.zhumouren.twitter.cloud.tweet.entity.ReplyQuote;
import cn.zhumouren.twitter.cloud.tweet.mapper.ReplyQuoteMapper;
import cn.zhumouren.twitter.cloud.tweet.service.IReplyQuoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 回复引用表 服务实现类
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Service
public class ReplyQuoteServiceImpl extends ServiceImpl<ReplyQuoteMapper, ReplyQuote> implements IReplyQuoteService {

}
