package cn.zhumouren.twitter.cloud.user.service.impl;

import cn.zhumouren.twitter.cloud.user.entity.DetailUser;
import cn.zhumouren.twitter.cloud.user.mapper.DetailUserMapper;
import cn.zhumouren.twitter.cloud.user.service.IDetailUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户细节表 服务实现类
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Service
public class DetailUserServiceImpl extends ServiceImpl<DetailUserMapper, DetailUser> implements IDetailUserService {

}
