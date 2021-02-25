package cn.zhumouren.twitter.cloud.timeline.constant;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/25 0:29
 * @Version 1.0
 **/
public class RedisStatusKeyConstant {

    public final static String STATUS_KEY = "status:id:";

    public final static String statusTreeIdKey = "status:tree:";

    /**
     * 通过statusId获取status key
     *
     * @param statusId
     * @return
     */
    public static String getStatusKey(String statusId) {
        return STATUS_KEY + statusId;
    }

    public static String getStatusTreeIdKey() {
        return statusTreeIdKey;
    }
}
