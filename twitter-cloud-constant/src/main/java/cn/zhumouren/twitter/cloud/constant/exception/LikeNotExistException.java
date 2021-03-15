package cn.zhumouren.twitter.cloud.constant.exception;

import cn.zhumouren.twitter.cloud.constant.result.ResultStatus;

/**
 * @Description 点赞不存在
 * @Author mourenZhu
 * @Date 2021/3/15 15:01
 * @Version 1.0
 **/
public class LikeNotExistException extends Exception {

    private final ResultStatus resultStatus;

    public LikeNotExistException() {
        super(ResultStatus.LIKE_NOT_EXIST.getMessage());
        this.resultStatus = ResultStatus.LIKE_NOT_EXIST;
    }

    public LikeNotExistException(String message) {
        super(message);
        this.resultStatus = ResultStatus.LIKE_NOT_EXIST;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }
}
