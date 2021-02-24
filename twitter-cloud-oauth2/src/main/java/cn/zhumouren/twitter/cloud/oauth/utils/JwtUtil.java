package cn.zhumouren.twitter.cloud.oauth.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author mourenZhu
 */
public class JwtUtil {
    public static Date expirationTime(Integer second){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, second);
        return calendar.getTime();
    }
}
