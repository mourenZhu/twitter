package cn.zhumouren.twitter.cloud.test.tweet;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/17 16:00
 * @Version 1.0
 **/
public class TweetTest {

    @Test
    public void listTest(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("当前值");
        for (Integer i : list){
            System.out.println(i);
        }
        System.out.println("最后的值");
        System.out.println(list.remove(list.size() - 1));
        System.out.println("移除后的值");
        for (Integer i : list){
            System.out.println(i);
        }
    }

    @Test
    public void nullTest(){
        Integer i = null;
        if (null == i){
            System.out.println();
        }
        if (i == null){
            System.out.println("???");
        }
    }
}
