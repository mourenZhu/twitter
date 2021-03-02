package cn.zhumouren.twitter.cloud.user.controller.annotation;

import cn.zhumouren.twitter.cloud.constant.exception.TweetNotExistException;
import cn.zhumouren.twitter.cloud.constant.result.JsonResult;
import cn.zhumouren.twitter.cloud.constant.result.annotation.ResponseResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.util.WebUtils;

import java.lang.annotation.Annotation;

/**
 * @Description 统一json格式
 * @Author mourenZhu
 * @Date 2021/2/16 16:15
 * @Version 1.0
 **/

@RestControllerAdvice
@Slf4j
public class ResponseResultBodyAdvice implements ResponseBodyAdvice<Object> {


    private static final Class<? extends Annotation> ANNOTATION_TYPE = ResponseResultBody.class;

    /**
     * 判断类或者方法是否使用了 @ResponseResultBody
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return AnnotatedElementUtils.hasAnnotation(methodParameter.getContainingClass(), ANNOTATION_TYPE) || methodParameter.hasMethodAnnotation(ANNOTATION_TYPE);
    }

    /**
     * 当类或者方法使用了 @ResponseResultBody 就会调用这个方法
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 防止重复包裹的问题出现
        if (body instanceof JsonResult) {
            return body;
        }
        return JsonResult.success(body);
    }

    /**
     * 提供对标准Spring MVC异常的处理
     *
     * @param ex      the target exception
     * @param request the current request
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<JsonResult<?>> exceptionHandler(Exception ex, WebRequest request) {
        log.error("ExceptionHandler: {}", ex.getMessage());
        HttpHeaders headers = new HttpHeaders();
        if (ex instanceof TweetNotExistException) {
            return this.handleResultException((TweetNotExistException) ex, headers, request);
        }
        // TODO: 2019/10/05 galaxy 这里可以自定义其他的异常拦截
        return this.handleException(ex, headers, request);
    }

    /**
     * 对TweetNotExistException类返回返回结果的处理
     */
    protected ResponseEntity<JsonResult<?>> handleResultException(TweetNotExistException ex, HttpHeaders headers, WebRequest request) {
        JsonResult<?> body = JsonResult.failure(ex.getResultStatus());
        HttpStatus status = ex.getResultStatus().getHttpStatus();
        return this.handleExceptionInternal(ex, body, headers, status, request);
    }

    /**
     * 异常类的统一处理
     */
    protected ResponseEntity<JsonResult<?>> handleException(Exception ex, HttpHeaders headers, WebRequest request) {
        JsonResult<?> body = JsonResult.failure();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return this.handleExceptionInternal(ex, body, headers, status, request);
    }

    /**
     * org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#handleExceptionInternal(java.lang.Exception, java.lang.Object, org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus, org.springframework.web.context.request.WebRequest)
     * <p>
     * A single place to customize the response body of all exception types.
     * <p>The default implementation sets the {@link WebUtils#ERROR_EXCEPTION_ATTRIBUTE}
     * request attribute and creates a {@link ResponseEntity} from the given
     * body, headers, and status.
     */
    protected ResponseEntity<JsonResult<?>> handleExceptionInternal(
            Exception ex, JsonResult<?> body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<>(body, headers, status);
    }

}
