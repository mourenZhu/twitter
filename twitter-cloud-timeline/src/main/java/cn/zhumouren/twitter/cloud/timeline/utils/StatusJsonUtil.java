package cn.zhumouren.twitter.cloud.timeline.utils;

import cn.zhumouren.twitter.cloud.constant.exception.TweetDeletedException;
import cn.zhumouren.twitter.cloud.constant.exception.TweetNotExistException;
import cn.zhumouren.twitter.cloud.constant.utils.list.ListUtils;
import cn.zhumouren.twitter.cloud.timeline.domain.StatusJson;
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

    public static StatusJson getStatus(JSONObject jsonObject) throws TweetNotExistException, TweetDeletedException {
        StatusJson statusJson = jsonObject.getObject("data", StatusJson.class);
        Integer code = jsonObject.getInteger("code");
        switch (code) {
            case 851:
                throw new TweetNotExistException();
            case 852:
                throw new TweetDeletedException();
        }
        return statusJson;
    }

    public static List<StatusJson> listStatus(JSONObject jsonObject) {
        List data = jsonObject.getObject("data", List.class);
        List<StatusJson> statusJsonList = JSON.parseArray(JSON.toJSONString(data), StatusJson.class);
        return statusJsonList;
    }

    public static List<Long> listStatusId(JSONObject jsonObject) {
        List<String> data = jsonObject.getObject("data", List.class);
        List<Long> statusIdList = ListUtils.toLongList(data);
        return statusIdList;
    }

    public static List<Long> listStatusChildId(JSONObject jsonObject) {
        List<String> data = jsonObject.getObject("data", List.class);
        return ListUtils.toLongList(data);
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
        declaredField.setAccessible(true);
        Object o = declaredField.get(statusJson);
        declaredField.setAccessible(false);
        return o;
    }

}
