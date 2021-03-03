package cn.zhumouren.twitter.cloud.timeline.service.impl;

import cn.zhumouren.twitter.cloud.constant.exception.UserNotExistException;
import cn.zhumouren.twitter.cloud.timeline.constant.redis.UserKeyConstant;
import cn.zhumouren.twitter.cloud.timeline.domain.UserJson;
import cn.zhumouren.twitter.cloud.timeline.service.IUserService;
import cn.zhumouren.twitter.cloud.timeline.service.client.impl.UserServerDetailUserClientImpl;
import cn.zhumouren.twitter.cloud.timeline.utils.RedisUtil;
import cn.zhumouren.twitter.cloud.timeline.utils.UserJsonUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/2 22:36
 * @Version 1.0
 **/
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserServerDetailUserClientImpl userClient;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean pushUser(UserJson userJson) {
        boolean is = false;
        List<String> items = UserJsonUtil.listUserField();
        for (String item : items) {
            try {
                is = redisUtil.hset(UserKeyConstant.getUserKey(userJson.getUid().toString()), item, UserJsonUtil.getUserFieldValue(item, userJson));
            } catch (NoSuchFieldException e) {
                log.error(e.getMessage());
            } catch (IllegalAccessException e) {
                log.error(e.getMessage());
            }
        }
        return is;
    }

    @Override
    public UserJson getUser(Long uid) throws UserNotExistException {
        if (!redisUtil.hasKey(UserKeyConstant.getUserKey(uid.toString()))){
            pushUser(userClient.getDetailUser(uid));
        }
        Map<Object, Object> userMap = redisUtil.hmget(UserKeyConstant.getUserKey(uid.toString()));
        UserJson userJson = JSONObject.parseObject(JSONObject.toJSONString(userMap), UserJson.class);
        return userJson;
    }
}
