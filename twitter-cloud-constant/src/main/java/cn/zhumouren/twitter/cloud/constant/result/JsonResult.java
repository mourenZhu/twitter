package cn.zhumouren.twitter.cloud.constant.result;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/16 16:27
 * @Version 1.0
 **/
public class JsonResult<T> {

    /**
     * 业务错误码
     */
    private final Integer code;
    /**
     * 信息描述
     */
    private final String message;
    /**
     * 返回参数
     */
    private final T data;
    private JsonResult(ResultStatus resultStatus, T data) {
        this.code = resultStatus.getCode();
        this.message = resultStatus.getMessage();
        this.data = data;
    }

    /**
     * 业务成功返回业务代码和描述信息
     */
    public static JsonResult<Void> success() {
        return new JsonResult<Void>(ResultStatus.SUCCESS, null);
    }

    /**
     * 业务成功返回业务代码,描述和返回的参数
     */
    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<T>(ResultStatus.SUCCESS, data);
    }

    /**
     * 业务成功返回业务代码,描述和返回的参数
     */
    public static <T> JsonResult<T> success(ResultStatus resultStatus, T data) {
        if (resultStatus == null) {
            return success(data);
        }
        return new JsonResult<T>(resultStatus, data);
    }

    /**
     * 业务异常返回业务代码和描述信息
     */
    public static <T> JsonResult<T> failure() {
        return new JsonResult<T>(ResultStatus.INTERNAL_SERVER_ERROR, null);
    }

    /**
     * 业务异常返回业务代码,描述和返回的参数
     */
    public static <T> JsonResult<T> failure(ResultStatus resultStatus) {
        return failure(resultStatus, null);
    }

    /**
     * 业务异常返回业务代码,描述和返回的参数
     */
    public static <T> JsonResult<T> failure(ResultStatus resultStatus, T data) {
        if (resultStatus == null) {
            return new JsonResult<T>(ResultStatus.INTERNAL_SERVER_ERROR, null);
        }
        return new JsonResult<T>(resultStatus, data);
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
