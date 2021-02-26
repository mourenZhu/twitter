package cn.zhumouren.twitter.cloud.timeline.service.impl;

import cn.zhumouren.twitter.cloud.timeline.constant.redis.StatusKeyConstant;
import cn.zhumouren.twitter.cloud.timeline.domain.StatusJson;
import cn.zhumouren.twitter.cloud.timeline.service.IStatusService;
import cn.zhumouren.twitter.cloud.timeline.utils.RedisUtil;
import cn.zhumouren.twitter.cloud.timeline.utils.StatusJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/25 0:14
 * @Version 1.0
 **/
@Service
public class StatusServiceImpl implements IStatusService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean pushStatus(StatusJson statusJson) throws NoSuchFieldException, IllegalAccessException {
        if (!redisUtil.hasKey(statusJson.getId().toString())) {
            List<String> itemList = StatusJsonUtil.listStatusField();
            for (String s : itemList) {
                redisUtil.hset(StatusKeyConstant.getStatusKey(statusJson.getId().toString()), s, StatusJsonUtil.getStatusFieldValue(s, statusJson));
            }
        }
        return true;
    }

    @Override
    public boolean pushStatusList(List<StatusJson> statusJsons) throws NoSuchFieldException, IllegalAccessException {
        boolean bool = true;
        for (StatusJson statusJson : statusJsons) {
            bool = pushStatus(statusJson);
        }
        return bool;
    }
}
