package cn.zhumouren.twitter.cloud.timeline.utils;

import org.junit.Test;

import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/27 0:40
 * @Version 1.0
 **/
public class StatusJsonUtilTest {

    @Test
    public void listStatusFieldTest(){
        List<String> list = StatusJsonUtil.listStatusField();
        for (String s : list){
            System.out.println(s);
        }
    }
}
