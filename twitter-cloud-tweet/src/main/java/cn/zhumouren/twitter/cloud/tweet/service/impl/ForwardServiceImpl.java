package cn.zhumouren.twitter.cloud.tweet.service.impl;

import cn.zhumouren.twitter.cloud.tweet.entity.Forward;
import cn.zhumouren.twitter.cloud.tweet.mapper.ForwardMapper;
import cn.zhumouren.twitter.cloud.tweet.service.IForwardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 推文转发表 服务实现类
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Service
public class ForwardServiceImpl extends ServiceImpl<ForwardMapper, Forward> implements IForwardService {

}
