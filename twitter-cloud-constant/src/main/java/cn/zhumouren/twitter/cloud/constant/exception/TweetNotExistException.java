package cn.zhumouren.twitter.cloud.constant.exception;

import cn.zhumouren.twitter.cloud.constant.result.ResultStatus;

/**
 * @Description 推文为空异常
 * @Author mourenZhu
 * @Date 2021/2/16 20:16
 * @Version 1.0
 **/

public class TweetNotExistException extends RuntimeException {

    private final ResultStatus resultStatus;

    public TweetNotExistException() {
        super(ResultStatus.TWEET_NOT_EXIST.getMessage());
        this.resultStatus = ResultStatus.TWEET_NOT_EXIST;
    }

    public TweetNotExistException(String message) {
        super(message);
        this.resultStatus = ResultStatus.TWEET_NOT_EXIST;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }
}
