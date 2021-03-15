package cn.zhumouren.twitter.cloud.tweet.service.impl;

import cn.zhumouren.twitter.cloud.constant.exception.LikeNotExistException;
import cn.zhumouren.twitter.cloud.constant.exception.NotInsertLikeException;
import cn.zhumouren.twitter.cloud.tweet.entity.Like;
import cn.zhumouren.twitter.cloud.tweet.mapper.DatabaseTweetNumFieldName;
import cn.zhumouren.twitter.cloud.tweet.mapper.LikeMapper;
import cn.zhumouren.twitter.cloud.tweet.mapper.TweetMapper;
import cn.zhumouren.twitter.cloud.tweet.service.ILikeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 推文点赞表 服务实现类
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@Service
public class LikeServiceImpl extends ServiceImpl<LikeMapper, Like> implements ILikeService {

    @Autowired
    private LikeMapper likeMapper;

    @Autowired
    private TweetMapper tweetMapper;

    @Override
    public boolean postLike(Long tweetId, Long userId) throws NotInsertLikeException {
        boolean b = likeMapper.insertLike(tweetId, userId);
        if (b) {
            b = tweetMapper.addFieldNums(DatabaseTweetNumFieldName.NUM_LIKES, tweetId);
            return b;
        }
        throw new NotInsertLikeException();
    }

    @Override
    public boolean deleteLike(Long tweetId, Long userId) throws LikeNotExistException {
        int i = likeMapper.deleteLike(tweetId, userId);
        if (i > 0) {
            return tweetMapper.subFieldNums(DatabaseTweetNumFieldName.NUM_LIKES, tweetId);
        }
        throw new LikeNotExistException();
    }

    @Override
    public List<Long> listUserLikeTweetId(Long userId) {
        return likeMapper.listUserLikeTweetId(userId);
    }
}
