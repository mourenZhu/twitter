package cn.zhumouren.twitter.cloud.constant.exception;

import cn.zhumouren.twitter.cloud.constant.result.ResultStatus;

/**
 * @Description 推文不存在或者已删除
 * @Author mourenZhu
 * @Date 2021/3/11 21:26
 * @Version 1.0
 **/
public class TweetNotExistOrDeletedException extends Exception {
    private final ResultStatus resultStatus;

    public TweetNotExistOrDeletedException() {
        super(ResultStatus.TWEET_NOT_EXIST_OR_DELETED.getMessage());
        this.resultStatus = ResultStatus.TWEET_NOT_EXIST_OR_DELETED;
    }

    public TweetNotExistOrDeletedException(String message) {
        super(message);
        this.resultStatus = ResultStatus.TWEET_NOT_EXIST_OR_DELETED;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }
}
