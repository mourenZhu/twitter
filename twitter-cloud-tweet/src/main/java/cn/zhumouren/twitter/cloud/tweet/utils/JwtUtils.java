package cn.zhumouren.twitter.cloud.tweet.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;

public class JwtUtils {

    public static String getString(String accessToken, String name){
        Jwt jwt = JwtHelper.decode(accessToken);
        JSONObject jsonObject = JSONObject.parseObject(jwt.getClaims());
        return jsonObject.getString(name);
    }

    public static Integer getInteger(String accessToken, String param){
        Jwt jwt = JwtHelper.decode(accessToken);
        JSONObject jsonObject = JSONObject.parseObject(jwt.getClaims());
        return jsonObject.getInteger(param);
    }

    /**
     * 前端直接用long类型会出现精度丢失，所以用string存。后端获取的时候要转换一下。
     * @param accessToken
     * @param param
     * @return
     */
    public static Long getLongByString(String accessToken, String param){
        Jwt jwt = JwtHelper.decode(accessToken);
        JSONObject jsonObject = JSONObject.parseObject(jwt.getClaims());
        return Long.valueOf(jsonObject.getString(param));
    }

    public static Long getLong(String accessToken, String param){
        Jwt jwt = JwtHelper.decode(accessToken);
        JSONObject jsonObject = JSONObject.parseObject(jwt.getClaims());
        return jsonObject.getLong(param);
    }

}
