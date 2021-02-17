package cn.zhumouren.twitter.cloud.gateway.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.jwt.Jwt;

import java.util.ArrayList;

/**
 * @author mourenZhu
 */
public class JwtUtils {
    public static ArrayList<String> getAuthorities(Jwt jwt) {

        ArrayList list = new ArrayList();
        JSONObject jsonObject = JSONObject.parseObject(jwt.getClaims());
        JSONArray plist = JSON.parseArray(jsonObject.getJSONArray("authorities").toJSONString());
        Object[] objects = plist.toArray();
        for (Object o : objects) {
            list.add(o.toString());
        }
        return list;
    }

    public static Integer getInteger(Jwt jwt, String param){
        JSONObject jsonObject = JSONObject.parseObject(jwt.getClaims());
        return jsonObject.getInteger(param);
    }
}
