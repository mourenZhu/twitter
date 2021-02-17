package cn.zhumouren.twitter.cloud.tweet.constant;


import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * @author mourenZhu
 */

@ToString
@Getter
public enum ResultStatus {

    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, -1, "unknown error！"),

    SUCCESS(HttpStatus.OK, 200, "OK"),

    BAD_REQUEST(HttpStatus.BAD_REQUEST, 400, "Bad Request"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "Internal Server Error"),

    TWEET_NOT_EXIST(HttpStatus.OK, 851, "tweet is not exist！");

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

}
