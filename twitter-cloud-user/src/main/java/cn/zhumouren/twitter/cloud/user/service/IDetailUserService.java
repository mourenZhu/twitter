package cn.zhumouren.twitter.cloud.user.service;

import cn.zhumouren.twitter.cloud.user.entity.DetailUser;
import cn.zhumouren.twitter.cloud.user.vo.DetailUserVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户细节表 服务类
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
public interface IDetailUserService extends IService<DetailUser> {

    /**
     * 获取展示层user对象
     * @param uid
     * @return
     */
    DetailUserVO getDetailUserVO(Long uid);

    /**
     * 更新用户详细信息
     * @param detailUserVO
     * @return
     */
    boolean updateDetailUser(DetailUserVO detailUserVO);

}
