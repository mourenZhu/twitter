package cn.zhumouren.twitter.cloud.tweet.service.exception;

import cn.zhumouren.twitter.cloud.tweet.constant.ResultStatus;
import lombok.Getter;

/**
 * @Description 推文为空异常
 * @Author mourenZhu
 * @Date 2021/2/16 20:16
 * @Version 1.0
 **/
@Getter
public class TweetNotExistException extends Exception{

    private ResultStatus resultStatus;

    public TweetNotExistException(){
        super();
        this.resultStatus = ResultStatus.TWEET_NOT_EXIST;
    }

    public TweetNotExistException(String message){
        super(message);
        this.resultStatus = ResultStatus.TWEET_NOT_EXIST;
    }
}
