package cn.zhumouren.twitter.cloud.timeline.service.client.impl;

import cn.zhumouren.twitter.cloud.constant.exception.UserNotExistException;
import cn.zhumouren.twitter.cloud.timeline.service.client.IOauthServerUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/3 22:30
 * @Version 1.0
 **/
@Service
public class OauthServerUserClientImpl {

    @Autowired
    private IOauthServerUserClient oauthServerUserClient;

    public String getUsername(Long uid) throws UserNotExistException{
        String username = oauthServerUserClient.getUsername(uid.toString());
        if ("".equals(username) || null == username){
            throw new UserNotExistException();
        }
        return username;
    }
}
