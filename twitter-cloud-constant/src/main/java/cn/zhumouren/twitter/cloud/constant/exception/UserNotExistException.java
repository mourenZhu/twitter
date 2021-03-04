package cn.zhumouren.twitter.cloud.constant.exception;

import cn.zhumouren.twitter.cloud.constant.result.ResultStatus;

/**
 * @Description 用户不存在异常
 * @Author mourenZhu
 * @Date 2021/3/3 14:29
 * @Version 1.0
 **/
public class UserNotExistException extends Exception{

    private final ResultStatus resultStatus;

    public UserNotExistException(){
        super(ResultStatus.USER_NOT_EXIST.getMessage());
        this.resultStatus = ResultStatus.USER_NOT_EXIST;
    }

    public UserNotExistException(String message){
        super(message);
        this.resultStatus = ResultStatus.USER_NOT_EXIST;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

}
