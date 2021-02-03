package cn.zhumouren.twitter.cloud.oauth.service.impl;

import cn.zhumouren.twitter.cloud.oauth.entity.ClientToken;
import cn.zhumouren.twitter.cloud.oauth.mapper.ClientTokenMapper;
import cn.zhumouren.twitter.cloud.oauth.service.IClientTokenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhumouren
 * @since 2021-01-14
 */
@Service
public class ClientTokenServiceImpl extends ServiceImpl<ClientTokenMapper, ClientToken> implements IClientTokenService {

}
