package cn.zhumouren.twitter.cloud.timeline.constant.redis;

/**
 * @author mourenZhu
 */

public enum StatusItemConstant {

    STATUS_JSON_ITEM("jsonData");

    private final String item;

    StatusItemConstant(String item) {
        this.item = item;
    }

    public static String getJsonDataItem() {
        return STATUS_JSON_ITEM.item;
    }


}
