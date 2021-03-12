package cn.zhumouren.twitter.cloud.tweet.constant;

/**
 * @Description 操作类型
 * @Author mourenZhu
 * @Date 2021/3/12 14:32
 * @Version 1.0
 **/
public enum ClickType {

    FORWARD("转发"),

    LIKE("点赞");

    private String value;

    private ClickType(String value){
        this.value = value;
    }
}
