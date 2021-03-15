package cn.zhumouren.twitter.cloud.constant.result;


import org.springframework.http.HttpStatus;

/**
 * @author mourenZhu
 */

public enum ResultStatus {

    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, -1, "unknown error！"),

    SUCCESS(HttpStatus.OK, 200, "OK"),

    BAD_REQUEST(HttpStatus.BAD_REQUEST, 400, "Bad Request"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "Internal Server Error"),

    USER_NOT_EXIST(HttpStatus.OK, 751, "user is not exist!"),

    TWEET_NOT_EXIST_OR_DELETED(HttpStatus.OK, 850, "tweet is not exist or deleted！"),

    TWEET_NOT_EXIST(HttpStatus.OK, 851, "tweet is not exist！"),

    TWEET_DELETED(HttpStatus.OK, 852, "tweet is deleted!"),

    LIKE_NOT_EXIST(HttpStatus.OK, 861, "tweet like is not exist!"),

    NOT_INSERT_LIKE(HttpStatus.OK, 862, "not insert like, check tweet and like!"),

    QUOTE_NOT_EXIST(HttpStatus.OK, 863, "tweet quote is not exist!"),

    FORWARD_NOT_EXIST(HttpStatus.OK, 865, "tweet forward is not exist!"),

    NOT_INSERT_FORWARD(HttpStatus.OK, 866, "not insert forward, check tweet and forward!");


    /**
     * 返回的HTTP状态码,  符合http请求
     */
    private final HttpStatus httpStatus;
    /**
     * 业务异常码
     */
    private final Integer code;
    /**
     * 业务异常信息描述
     */
    private final String message;

    ResultStatus(HttpStatus httpStatus, Integer code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ResultStatus{" +
                "httpStatus=" + httpStatus +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
