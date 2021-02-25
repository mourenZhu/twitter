package cn.zhumouren.twitter.cloud.timeline.utils;

import cn.zhumouren.twitter.cloud.timeline.domain.StatusJson;
import cn.zhumouren.twitter.cloud.utils.list.ListUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/24 23:56
 * @Version 1.0
 **/
public class StatusJsonUtil {

    public static List<StatusJson> toStatusList(JSONObject jsonObject) {
        List data = jsonObject.getObject("data", List.class);
        List<StatusJson> statusJsonList = JSON.parseArray(JSON.toJSONString(data), StatusJson.class);
        return statusJsonList;
    }

    public static List<Long> toStatusIdList(JSONObject jsonObject) {
        List<String> data = jsonObject.getObject("data", List.class);
        List<Long> statusIdList = ListUtils.toLongList(data);
        return statusIdList;
    }

}
