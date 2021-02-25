package cn.zhumouren.twitter.cloud.utils.list;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/25 14:21
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

    public static List<String> toStringList(List<Long> longList){
        List<String> stringList = new LinkedList<>();
        for (Long l : longList){
            stringList.add(l.toString());
        }
        return stringList;
    }
}
