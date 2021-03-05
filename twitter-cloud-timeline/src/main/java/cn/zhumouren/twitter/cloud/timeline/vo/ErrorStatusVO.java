package cn.zhumouren.twitter.cloud.timeline.vo;

import lombok.Data;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/4 22:53
 * @Version 1.0
 **/
@Data
public class ErrorStatusVO extends StatusVO {

    private Integer errorCode;

    private String errorMessage;

    public ErrorStatusVO(StatusVO statusVO) {
        super(statusVO);
    }

    public ErrorStatusVO(Long id, Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.setId(id);
        this.setDeleted(false);
    }

    @Override
    public String toString() {
        return super.toString() + "ErrorStatusVO{" +
                "errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
