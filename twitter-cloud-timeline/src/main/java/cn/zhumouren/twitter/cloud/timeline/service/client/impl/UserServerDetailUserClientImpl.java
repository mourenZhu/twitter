package cn.zhumouren.twitter.cloud.timeline.service.client.impl;

import cn.zhumouren.twitter.cloud.constant.exception.UserNotExistException;
import cn.zhumouren.twitter.cloud.timeline.domain.UserJson;
import cn.zhumouren.twitter.cloud.timeline.service.client.IUserServerDetailUserClient;
import cn.zhumouren.twitter.cloud.timeline.utils.UserJsonUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/2 22:09
 * @Version 1.0
 **/
@Service
public class UserServerDetailUserClientImpl {

    @Autowired
    private IUserServerDetailUserClient iUserServerDetailUserClient;

    @Autowired
    private OauthServerUserClientImpl oauthServerUserClient;

    public UserJson getDetailUser(Long uid) throws UserNotExistException {
        JSONObject jsonObject = iUserServerDetailUserClient.getDetailUserJson(uid.toString());
        UserJson userJson = UserJsonUtil.getUserJson(jsonObject);
        userJson.setUsername(oauthServerUserClient.getUsername(uid));
        return userJson;
    }

}
