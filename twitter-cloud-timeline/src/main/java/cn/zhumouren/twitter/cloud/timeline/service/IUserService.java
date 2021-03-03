package cn.zhumouren.twitter.cloud.timeline.service;

import cn.zhumouren.twitter.cloud.timeline.domain.UserJson;

/**
 * @author mourenZhu
 */
public interface IUserService {

    /**
     * 在redis中存入user
     *
     * @param userJson
     * @return
     */
    boolean pushUser(UserJson userJson);

    /**
     * 通过uid 获得user
     *
     * @param uid
     * @return
     */
    UserJson getUser(Long uid);
}
