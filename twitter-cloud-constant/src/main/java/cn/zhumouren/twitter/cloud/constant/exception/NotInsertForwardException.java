package cn.zhumouren.twitter.cloud.constant.exception;

import cn.zhumouren.twitter.cloud.constant.result.ResultStatus;

/**
 * @Description 不能插入转发异常
 * @Author mourenZhu
 * @Date 2021/3/15 15:32
 * @Version 1.0
 **/
public class NotInsertForwardException extends Exception {

    private final ResultStatus resultStatus;

    public NotInsertForwardException() {
        super(ResultStatus.NOT_INSERT_FORWARD.getMessage());
        this.resultStatus = ResultStatus.NOT_INSERT_FORWARD;
    }

    public NotInsertForwardException(String message) {
        super(message);
        this.resultStatus = ResultStatus.NOT_INSERT_FORWARD;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }
}
