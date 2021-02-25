package cn.zhumouren.twitter.cloud.timeline.constant;

/**
 * @Description 用于记录在redis中key的值
 * @Author mourenZhu
 * @Date 2021/2/25 14:50
 * @Version 1.0
 **/
public class RedisUserKeyConstant {

    /**
     * 该值后加user id 可获得用户
     */
    public final static String USER_KEY = "user:id:";

    /**
     * 该值后加username可获得uid
     */
    public final static String USER_ID_KEY = "user:username:";

    public final static String USER_FOLLOWING_KEY = ":following";

    public final static String USER_FOLLOWERS_KEY = ":followers";

    public final static String USER_POSTS_KEY = ":posts";

    public final static String HOME_TIMELINE_KEY = ":timeline";

    /**
     * 通过uid获取该用户对象的key
     *
     * @param uid
     * @return
     */
    public static String getUserKey(String uid) {
        return USER_KEY + uid;
    }

    /**
     * 通过username获取用户的uid Key
     *
     * @param username
     * @return
     */
    public static String getUserIdKey(String username) {
        return USER_ID_KEY + username;
    }

    /**
     * 通过 uid 获取用户的following Key
     *
     * @param uid
     * @return
     */
    public static String getUserFollowingKey(String uid) {
        return USER_KEY + uid + USER_FOLLOWING_KEY;
    }

    /**
     * 通过uid 获取用户的followers key
     *
     * @param uid
     * @return
     */
    public static String getUserFollowersKey(String uid) {
        return USER_KEY + uid + USER_FOLLOWERS_KEY;
    }

    /**
     * 通过uid 获得用户所有推文key
     *
     * @param uid
     * @return
     */
    public static String getUserPostsKey(String uid) {
        return USER_KEY + uid + USER_POSTS_KEY;
    }

    /**
     * 通过uid 获得用户 home timeline key
     *
     * @param uid
     * @return
     */
    public static String getHomeTimelineKey(String uid) {
        return USER_KEY + uid + HOME_TIMELINE_KEY;
    }
}
