package cn.zhumouren.twitter.cloud.tweet.dto;

import cn.zhumouren.twitter.cloud.tweet.constant.ClickType;
import cn.zhumouren.twitter.cloud.tweet.entity.Forward;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/12 14:20
 * @Version 1.0
 **/
@Data
public class ClickStatusDTO extends StatusDTO{

    private Long clickUserId;

    private ClickType clickType;

    private LocalDateTime clickTime;

    public ClickStatusDTO() {}

}
