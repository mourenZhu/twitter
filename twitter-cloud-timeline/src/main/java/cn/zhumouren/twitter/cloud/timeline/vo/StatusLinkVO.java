package cn.zhumouren.twitter.cloud.timeline.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/4 21:24
 * @Version 1.0
 **/
@Data
public class StatusLinkVO {

    private List<ErrorStatusVO> parentStatusVOList;

    private StatusVO currentStatusVO;

    private List<StatusVO> childStatusVOList;

    public StatusLinkVO(List<ErrorStatusVO> parentStatusVOList, StatusVO currentStatusVO, List<StatusVO> childStatusVOList) {
        this.parentStatusVOList = parentStatusVOList;
        this.currentStatusVO = currentStatusVO;
        this.childStatusVOList = childStatusVOList;
    }
}
