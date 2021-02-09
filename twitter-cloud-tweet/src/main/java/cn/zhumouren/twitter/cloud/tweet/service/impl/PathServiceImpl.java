package cn.zhumouren.twitter.cloud.tweet.service.impl;

import cn.zhumouren.twitter.cloud.tweet.entity.Path;
import cn.zhumouren.twitter.cloud.tweet.mapper.PathMapper;
import cn.zhumouren.twitter.cloud.tweet.service.IPathService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 回复闭包路径表 服务实现类
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-09
 */
@Service
public class PathServiceImpl extends ServiceImpl<PathMapper, Path> implements IPathService {

}
