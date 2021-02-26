package cn.zhumouren.twitter.cloud.timeline.service;

import cn.zhumouren.twitter.cloud.timeline.domain.StatusJson;

import java.util.List;

/**
 * @author mourenZhu
 */
public interface IStatusService {

    /**
     * 在redis中push status
     *
     * @param statusJson
     * @return
     */
    boolean pushStatus(StatusJson statusJson) throws NoSuchFieldException, IllegalAccessException;

    /**
     * 在redis中批量 push status
     *
     * @param statusJsons
     * @return
     */
    boolean pushStatusList(List<StatusJson> statusJsons) throws NoSuchFieldException, IllegalAccessException;
}
