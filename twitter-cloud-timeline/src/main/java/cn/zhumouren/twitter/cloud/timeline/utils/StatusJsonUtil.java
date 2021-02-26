package cn.zhumouren.twitter.cloud.timeline.utils;

import cn.zhumouren.twitter.cloud.timeline.domain.StatusJson;
import cn.zhumouren.twitter.cloud.utils.list.ListUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.LinkedList;
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

    public static List<String> listStatusField() {
        List<String> list = new LinkedList<>();
        Field[] declaredFields = StatusJson.class.getDeclaredFields();
        for (Field field : declaredFields) {
            list.add(field.getName());
        }
        return list;
    }

    public static Object getStatusFieldValue(String item, StatusJson statusJson) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = statusJson.getClass().getDeclaredField(item);
        return declaredField.get(statusJson);
    }

}
