package cn.zhumouren.twitter.cloud.oauth.config;

import cn.zhumouren.twitter.cloud.oauth.dto.JwtUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.Map;

public class JwtTokenEnhancer implements TokenEnhancer {

    @Autowired
    private JwtConfig jwtConfig;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> info = jwtConfig.getInfo();

        JwtUserDTO jwtUserDTO = (JwtUserDTO) authentication.getPrincipal();

        info.put("uid", jwtUserDTO.getId());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }

}
