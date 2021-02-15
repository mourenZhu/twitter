package cn.zhumouren.twitter.cloud.oauth.config;

import cn.zhumouren.twitter.cloud.oauth.dto.JwtUserDTO;
import cn.zhumouren.twitter.cloud.oauth.entity.SysPermission;
import cn.zhumouren.twitter.cloud.oauth.entity.SysUser;
import cn.zhumouren.twitter.cloud.oauth.service.ISysPermissionService;
import cn.zhumouren.twitter.cloud.oauth.service.ISysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        SysUser user = userService.getOne(queryWrapper);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (user != null) {
            List<SysPermission> sysPermissions = permissionService.selectByUsername(username);

            // 声明用户授权
            sysPermissions.forEach(sysPermission -> {
                if (sysPermission != null && sysPermission.getEnname() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sysPermission.getEnname());
                    grantedAuthorities.add(grantedAuthority);
                }
            });
        }

        return new JwtUserDTO(user.getId(), user.getUsername(), user.getPassword(),
                user.getEnabled(),
                user.getAccountNonExpired(),
                user.getCredentialsNonExpired(),
                user.getAccountNonLocked(),
                grantedAuthorities,
                user.getCreated(), user.getUpdated());
    }
}
