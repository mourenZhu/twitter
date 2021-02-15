package cn.zhumouren.twitter.cloud.oauth.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @Description 个人设计的User类相比于spring security框架提供的User类多一些属性
 * @Author mourenZhu
 * @Date 2021/2/15 22:48
 * @Version 1.0
 **/
public class JwtUserDTO extends User {

    /**
     * 用户雪花id
     */
    private Long id;

    private LocalDateTime created;

    private LocalDateTime updated;

    public JwtUserDTO(Long id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
    }

    public JwtUserDTO(Long id, String username, String password,
                      boolean enabled, boolean accountNonExpired,
                      boolean credentialsNonExpired, boolean accountNonLocked,
                      Collection<? extends GrantedAuthority> authorities,

                      LocalDateTime created, LocalDateTime updated) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
