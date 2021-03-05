package cn.zhumouren.twitter.cloud.timeline.constant.redis;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/25 0:29
 * @Version 1.0
 **/
public enum StatusKeyConstant {

    STATUS_KEY("status:id:"),

    STATUS_CHILD_ID_KEY(":child");

    private final String key;

    StatusKeyConstant(String key) {
        this.key = key;
    }

    /**
     * 通过statusId获取status key
     *
     * @param statusId
     * @return
     */
    public static String getStatusKey(String statusId) {
        return STATUS_KEY.key + statusId;
    }

    public static String getStatusChildIdKey(String statusId) {
        return getStatusKey(statusId) + STATUS_CHILD_ID_KEY.key;
    }

}
