package cn.zhumouren.twitter.cloud.oauth.service.impl;

import cn.zhumouren.twitter.cloud.oauth.entity.Code;
import cn.zhumouren.twitter.cloud.oauth.mapper.CodeMapper;
import cn.zhumouren.twitter.cloud.oauth.service.ICodeService;
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
public class CodeServiceImpl extends ServiceImpl<CodeMapper, Code> implements ICodeService {

}
