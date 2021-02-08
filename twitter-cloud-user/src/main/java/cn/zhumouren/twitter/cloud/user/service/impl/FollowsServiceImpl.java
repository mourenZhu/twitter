package cn.zhumouren.twitter.cloud.user.service.impl;

import cn.zhumouren.twitter.cloud.user.entity.Follows;
import cn.zhumouren.twitter.cloud.user.mapper.FollowsMapper;
import cn.zhumouren.twitter.cloud.user.service.IFollowsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户关注表 服务实现类
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Service
public class FollowsServiceImpl extends ServiceImpl<FollowsMapper, Follows> implements IFollowsService {

}
