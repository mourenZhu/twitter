package cn.zhumouren.twitter.cloud.timeline.utils;

import cn.zhumouren.twitter.cloud.constant.exception.UserNotExistException;
import cn.zhumouren.twitter.cloud.timeline.domain.StatusJson;
import cn.zhumouren.twitter.cloud.timeline.domain.UserJson;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/2 22:13
 * @Version 1.0
 **/
public class UserJsonUtil {

    public static UserJson getUserJson(JSONObject jsonObject) throws UserNotExistException {
        UserJson userJson = jsonObject.getObject("data", UserJson.class);
        if (userJson == null){
            throw new UserNotExistException();
        }
        return userJson;
    }

    public static List<String> listUserField() {
        List<String> list = new LinkedList<>();
        Field[] declaredFields = UserJson.class.getDeclaredFields();
        for (Field field : declaredFields) {
            list.add(field.getName());
        }
        return list;
    }

    public static Object getUserFieldValue(String item, UserJson userJson) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = userJson.getClass().getDeclaredField(item);
        declaredField.setAccessible(true);
        Object o = declaredField.get(userJson);
        declaredField.setAccessible(false);
        return o;
    }

}
