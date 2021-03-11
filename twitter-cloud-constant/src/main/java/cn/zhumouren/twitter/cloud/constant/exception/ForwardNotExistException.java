package cn.zhumouren.twitter.cloud.constant.exception;

import cn.zhumouren.twitter.cloud.constant.result.ResultStatus;

/**
 * @Description 转发不存在
 * @Author mourenZhu
 * @Date 2021/3/11 21:46
 * @Version 1.0
 **/
public class ForwardNotExistException extends Exception {

    private final ResultStatus resultStatus;

    public ForwardNotExistException() {
        super(ResultStatus.FORWARD_NOT_EXIST.getMessage());
        this.resultStatus = ResultStatus.FORWARD_NOT_EXIST;
    }

    public ForwardNotExistException(String message) {
        super(message);
        this.resultStatus = ResultStatus.FORWARD_NOT_EXIST;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }
}
