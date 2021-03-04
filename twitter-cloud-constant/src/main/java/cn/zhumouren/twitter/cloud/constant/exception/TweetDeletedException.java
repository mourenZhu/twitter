package cn.zhumouren.twitter.cloud.constant.exception;

import cn.zhumouren.twitter.cloud.constant.result.ResultStatus;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/4 21:40
 * @Version 1.0
 **/
public class TweetDeletedException extends Exception{
    private final ResultStatus resultStatus;

    public TweetDeletedException(){
        super(ResultStatus.TWEET_DELETED.getMessage());
        this.resultStatus = ResultStatus.TWEET_DELETED;
    }

    public TweetDeletedException(String message){
        super(message);
        this.resultStatus = ResultStatus.TWEET_DELETED;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }
}
