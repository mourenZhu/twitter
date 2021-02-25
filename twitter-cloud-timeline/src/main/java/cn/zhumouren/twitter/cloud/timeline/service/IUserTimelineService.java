package cn.zhumouren.twitter.cloud.timeline.service;

/**
 * @author mourenZhu
 */
public interface IUserTimelineService {

    /**
     * redis用户时间线是否存在
     *
     * @param userId
     * @return
     */
    boolean isExistUserTimeline(Long userId);

    /**
     * 构建用户的时间线
     *
     * @param userId
     * @return
     */
    boolean creatUserTimeline(Long userId);
}
