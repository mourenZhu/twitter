package cn.zhumouren.twitter.cloud.tweet.service.impl;

import cn.zhumouren.twitter.cloud.constant.exception.ForwardNotExistException;
import cn.zhumouren.twitter.cloud.constant.exception.NotInsertForwardException;
import cn.zhumouren.twitter.cloud.tweet.entity.Forward;
import cn.zhumouren.twitter.cloud.tweet.mapper.DatabaseTweetNumFieldName;
import cn.zhumouren.twitter.cloud.tweet.mapper.ForwardMapper;
import cn.zhumouren.twitter.cloud.tweet.mapper.TweetMapper;
import cn.zhumouren.twitter.cloud.tweet.service.IForwardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 推文转发表 服务实现类
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Service
public class ForwardServiceImpl extends ServiceImpl<ForwardMapper, Forward> implements IForwardService {

    @Autowired
    private ForwardMapper forwardMapper;

    @Autowired
    private TweetMapper tweetMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean postForward(Long tweetId, Long userId) throws NotInsertForwardException {
        boolean b = forwardMapper.insertForward(tweetId, userId);
        if (b) {
            b = tweetMapper.addFieldNums(DatabaseTweetNumFieldName.NUM_FORWARD, tweetId);
            return b;
        }
        throw new NotInsertForwardException();
    }

    @Override
    public boolean deleteForward(Long tweetId, Long userId) throws ForwardNotExistException {
        int i = forwardMapper.deleteForward(tweetId, userId);
        if (i > 0) {
            boolean b = tweetMapper.subFieldNums(DatabaseTweetNumFieldName.NUM_FORWARD, tweetId);
            return b;
        }
        throw new ForwardNotExistException();
    }

    @Override
    public List<Forward> listForwardByUser(Long userId) {
        return forwardMapper.listForwardByUser(userId);
    }

    @Override
    public List<Long> listForwardUserId(Long statusId) {
        return forwardMapper.listForwardUserId(statusId);
    }
}
