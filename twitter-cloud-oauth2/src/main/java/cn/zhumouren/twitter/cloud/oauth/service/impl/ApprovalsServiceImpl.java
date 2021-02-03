package cn.zhumouren.twitter.cloud.oauth.service.impl;

import cn.zhumouren.twitter.cloud.oauth.entity.Approvals;
import cn.zhumouren.twitter.cloud.oauth.mapper.ApprovalsMapper;
import cn.zhumouren.twitter.cloud.oauth.service.IApprovalsService;
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
public class ApprovalsServiceImpl extends ServiceImpl<ApprovalsMapper, Approvals> implements IApprovalsService {

}
