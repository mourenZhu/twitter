package cn.zhumouren.twitter.cloud.tweet.utils;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/24 14:59
 * @Version 1.0
 **/
public class ListUtils {
    public static List<Long> toLongList(List<String> stringList) {
        List<Long> longList = new LinkedList<>();
        for (String s : stringList) {
            longList.add(Long.valueOf(s));
        }
        return longList;
    }
}
