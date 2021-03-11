package cn.zhumouren.twitter.cloud.tweet.mapper;

/**
 * @author mourenZhu
 * @Description 在数据库tweet表中例如转发数的字段名
 * @since 2021-02-08
 */

public enum DatabaseTweetNumFieldName {

    NUM_LIKES("num_likes"),

    NUM_REPLIES("num_replies"),

    NUM_QUOTE("num_quote"),

    NUM_FORWARD("num_forward");

    private final String name;

    DatabaseTweetNumFieldName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
