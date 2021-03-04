package cn.zhumouren.twitter.cloud.timeline.service;

import cn.zhumouren.twitter.cloud.timeline.domain.StatusJson;
import cn.zhumouren.twitter.cloud.timeline.vo.StatusVO;

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
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    boolean pushStatus(StatusJson statusJson);

    /**
     * 在redis中批量 push status
     *
     * @param statusJsons
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    boolean pushStatusList(List<StatusJson> statusJsons);

    /**
     * 通过statusId 获取status json
     *
     * @param statusId
     * @return
     */
    StatusJson getStatusJson(Long statusId);

    /**
     * 获取 list status json
     *
     * @param statusIdList
     * @return
     */
    List<StatusJson> listStatusJson(List<Long> statusIdList);

    /**
     * 通过statusId 获取status VO
     *
     * @param statusId
     * @return
     */
    StatusVO getStatusVO(Long statusId);

    /**
     * 获取 list status vo
     *
     * @param statusIdList
     * @return
     */
    List<StatusVO> listStatusVO(List<Long> statusIdList);

}
