package cn.zhumouren.twitter.cloud.tweet.service.impl;

import cn.zhumouren.twitter.cloud.constant.exception.TweetDeletedException;
import cn.zhumouren.twitter.cloud.constant.exception.TweetNotExistException;
import cn.zhumouren.twitter.cloud.constant.utils.clazz.FieldUtils;
import cn.zhumouren.twitter.cloud.tweet.constant.ClickType;
import cn.zhumouren.twitter.cloud.tweet.dto.ClickStatusDTO;
import cn.zhumouren.twitter.cloud.tweet.dto.StatusDTO;
import cn.zhumouren.twitter.cloud.tweet.entity.Forward;
import cn.zhumouren.twitter.cloud.tweet.entity.ParentChildTweet;
import cn.zhumouren.twitter.cloud.tweet.entity.Tweet;
import cn.zhumouren.twitter.cloud.tweet.mapper.ForwardMapper;
import cn.zhumouren.twitter.cloud.tweet.mapper.ParentChildTweetMapper;
import cn.zhumouren.twitter.cloud.tweet.mapper.TweetMapper;
import cn.zhumouren.twitter.cloud.tweet.service.ITweetService;
import cn.zhumouren.twitter.cloud.tweet.vo.TweetLinkVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneOffset;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 推文表 服务实现类
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Service
public class TweetServiceImpl extends ServiceImpl<TweetMapper, Tweet> implements ITweetService {

    @Autowired
    private TweetMapper tweetMapper;

    @Autowired
    private ParentChildTweetMapper parentChildTweetMapper;

    @Autowired
    private ForwardMapper forwardMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean post(String content, List<String> pics, Long uid) {
        Tweet tweet = new Tweet();
        tweet.setUserId(uid);
        tweet.setContent(content);
        tweet.setPics(pics);
        int isPostTweet = tweetMapper.insert(tweet);
        int isParentChildTweet = parentChildTweetMapper.insert(new ParentChildTweet(tweet.getId(), tweet.getId(), 0, true));
        return SqlHelper.retBool(isPostTweet) && SqlHelper.retBool(isParentChildTweet);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean postReply(Long parentId, String content, List<String> pics, Long uid) {
        Tweet tweet = new Tweet();
        tweet.setUserId(uid);
        tweet.setContent(content);
        tweet.setPics(pics);
        int isPostTweet = tweetMapper.insert(tweet);
        boolean isPostTweetReply = parentChildTweetMapper.postTweetReply(parentId, tweet.getId());
        int isParentChildTweet = parentChildTweetMapper.insert(new ParentChildTweet(tweet.getId(), tweet.getId(), 0, false));
        boolean isReplyNums = tweetMapper.addReplyNums(parentId);
        return SqlHelper.retBool(isPostTweet) && isPostTweetReply && SqlHelper.retBool(isParentChildTweet) && isReplyNums;
    }

    @Override
    public boolean postTweet(String content, Long uid) {
        List<String> pics = new ArrayList();
        return postTweet(content, pics, uid);
    }

    @Override
    public boolean postTweet(String content, List<String> pics, Long uid) {
        return post(content, pics, uid);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deletedTweet(Long tweetId, Long uid) {
        boolean isReplyNums = true;
        Long parentId = parentChildTweetMapper.getParentId(tweetId, 1);
        if (null != parentId) {
            isReplyNums = tweetMapper.subReplyNums(parentId);
        }
        return tweetMapper.deletedTweet(tweetId, uid) && parentChildTweetMapper.deletedTweet(tweetId) && isReplyNums;
    }

    @Override
    public boolean postTweetReply(Long parentId, String replyContent, Long uid) throws TweetNotExistException {
        List<String> pics = new ArrayList<>();
        return postTweetReply(parentId, replyContent, pics, uid);
    }

    @Override
    public boolean postTweetReply(Long parentId, String replyContent, List<String> replyPics, Long uid) throws TweetNotExistException {
        if (tweetMapper.isExistTweet(parentId)) {
            return postReply(parentId, replyContent, replyPics, uid);
        } else {
            throw new TweetNotExistException();
        }
    }

    @Override
    public TweetLinkVO getTweetLinkVO(Page<Tweet> page, Long tweetId) {
        List<Tweet> tweetList = tweetMapper.listParentTweet(tweetId);
        IPage<Tweet> childTweetPage = tweetMapper.getChildTweetPage(page, tweetId);
        Tweet currentTweet = tweetList.remove(tweetList.size() - 1);
        return new TweetLinkVO(tweetList, currentTweet, childTweetPage);
    }

    @Override
    public IPage<Tweet> getUserTweetPage(Page<Tweet> page, Long userId) {
        return tweetMapper.getUserTweetPage(page, userId);
    }

    /**
     * 用户删除的推文不会出现在list中
     *
     * @param userId
     * @return
     */
    @Override
    public List<String> listUserStatusId(Long userId) {
        return tweetMapper.listUserStatusId(userId);
    }

    @Override
    public List<StatusDTO> listUserStatus(Long userId) {
        List<StatusDTO> statusDTOS = tweetMapper.listUserStatus(userId);
        List<Forward> forwards = forwardMapper.listForwardByUser(userId);
        List<ClickStatusDTO> clickStatusDTOList = listClickStatus(forwards);
        statusDTOS.addAll(clickStatusDTOList);
        statusListSort(statusDTOS);
        return statusDTOS;
    }

    private void statusListSort(List<StatusDTO> statusDTOS) {
        Collections.sort(statusDTOS, new Comparator<StatusDTO>() {
            @Override
            public int compare(StatusDTO o1, StatusDTO o2) {

                long l1 = o1.getCreated().toEpochSecond(ZoneOffset.of("+8"));
                long l2 = o2.getCreated().toEpochSecond(ZoneOffset.of("+8"));

                if (o1.getClass() == ClickStatusDTO.class) {
                    l1 = ((ClickStatusDTO) o1).getClickTime().toEpochSecond(ZoneOffset.of("+8"));
                }
                if (o2.getClass() == ClickStatusDTO.class) {
                    l2 = ((ClickStatusDTO) o2).getClickTime().toEpochSecond(ZoneOffset.of("+8"));
                }
                return (int) (l2 - l1);
            }
        });
    }

    /**
     * 先通过forward获取clickStatus对象
     *
     * @param forwards
     * @return
     */
    private List<ClickStatusDTO> listClickStatus(List<Forward> forwards) {
        List<ClickStatusDTO> clickStatusDTOList = new LinkedList<>();

        List<Long> statusIdList = new ArrayList<>();

        Map<Long, Forward> forwardsMap = forwards.stream().collect(Collectors
                .toMap(Forward::getTweetId, Function.identity(), (key1, key2) -> key2));

        for (Forward forward : forwards) {
            statusIdList.add(forward.getTweetId());
        }

        List<StatusDTO> statusDTOS = listStatus(statusIdList);

        for (StatusDTO statusDTO : statusDTOS) {
            Forward forward = forwardsMap.get(statusDTO.getId());
            ClickStatusDTO clickStatusDTO = new ClickStatusDTO();
            try {
                FieldUtils.fatherValueCopyToSonValue(statusDTO, clickStatusDTO);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            clickStatusDTO.setClickType(ClickType.FORWARD);
            clickStatusDTO.setClickUserId(forward.getUserId());
            clickStatusDTO.setClickTime(forward.getCreated());
            clickStatusDTOList.add(clickStatusDTO);
        }
        return clickStatusDTOList;
    }


    @Override
    public StatusDTO getStatus(Long statusId) throws TweetNotExistException, TweetDeletedException {
        if (tweetMapper.isExistTweet(statusId)) {
            StatusDTO status = tweetMapper.getStatus(statusId);
            if (status.getDeleted()) {
                throw new TweetDeletedException();
            }
            return status;
        } else {
            throw new TweetNotExistException();
        }
    }

    @Override
    public List<StatusDTO> listStatus(List<Long> statusIdList) {
        return tweetMapper.listStatus(statusIdList);
    }

    @Override
    public List<Long> listStatusChildId(Long statusId) {
        return tweetMapper.listStatusChildId(statusId);
    }
}
