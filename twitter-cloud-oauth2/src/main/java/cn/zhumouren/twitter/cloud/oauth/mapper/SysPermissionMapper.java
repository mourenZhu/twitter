package cn.zhumouren.twitter.cloud.oauth.mapper;

import cn.zhumouren.twitter.cloud.oauth.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author zhumouren
 * @since 2021-01-14
 */
@Repository
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 通过username获取权限
     *
     * @param username
     * @return
     */
    List<SysPermission> selectByUsername(String username);

    /**
     * 通过访问路径获得该路径所需要的权限
     *
     * @param url
     * @return
     */
    String getUrlPermission(@Param("url") String url);
}
