package cn.zhumouren.twitter.cloud.timeline.service;

/**
 * @author mourenZhu
 */
public interface IUserPostsService {

    /**
     * redis用户时间线是否存在
     *
     * @param userId
     * @return
     */
    boolean isExistUserTimeline(Long userId);

    /**
     * 构建用户的发布内容
     *
     * @param userId
     * @return
     */
    boolean creatUserPosts(Long userId);

    /**
     * 构建用户转发
     *
     * @param userId
     * @return
     */
    boolean creatUserForwards(Long userId);



}
