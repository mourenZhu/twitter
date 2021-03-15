package cn.zhumouren.twitter.cloud.constant.exception;

import cn.zhumouren.twitter.cloud.constant.result.ResultStatus;

/**
 * @Description 不能插入点赞异常
 * @Author mourenZhu
 * @Date 2021/3/15 15:32
 * @Version 1.0
 **/
public class NotInsertLikeException extends Exception {

    private final ResultStatus resultStatus;

    public NotInsertLikeException() {
        super(ResultStatus.NOT_INSERT_LIKE.getMessage());
        this.resultStatus = ResultStatus.NOT_INSERT_LIKE;
    }

    public NotInsertLikeException(String message) {
        super(ResultStatus.NOT_INSERT_LIKE.getMessage());
        this.resultStatus = ResultStatus.NOT_INSERT_LIKE;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }
}
