package cn.zhumouren.twitter.cloud.timeline.service;

import cn.zhumouren.twitter.cloud.constant.exception.TweetDeletedException;
import cn.zhumouren.twitter.cloud.constant.exception.TweetNotExistException;
import cn.zhumouren.twitter.cloud.constant.exception.UserNotExistException;
import cn.zhumouren.twitter.cloud.timeline.domain.StatusJson;
import cn.zhumouren.twitter.cloud.timeline.vo.StatusLinkVO;
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
     * @throws TweetNotExistException
     * @throws TweetDeletedException
     */
    StatusJson getStatusJson(Long statusId) throws TweetNotExistException, TweetDeletedException;

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
     * @throws TweetNotExistException
     * @throws UserNotExistException
     * @throws TweetDeletedException
     */
    StatusVO getStatusVO(Long statusId) throws TweetNotExistException, UserNotExistException, TweetDeletedException;

    /**
     * 获取 list status vo
     *
     * @param statusIdList
     * @return
     */
    List<StatusVO> listStatusVO(List<Long> statusIdList);

    /**
     * 获取详细的推文链
     *
     * @param statusId
     * @return
     * @throws TweetNotExistException
     * @throws UserNotExistException
     * @throws TweetDeletedException
     */
    StatusLinkVO getStatusLinkVO(Long statusId) throws TweetNotExistException, UserNotExistException, TweetDeletedException;

}
