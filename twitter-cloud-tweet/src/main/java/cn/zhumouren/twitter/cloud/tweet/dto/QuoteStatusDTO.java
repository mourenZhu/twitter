package cn.zhumouren.twitter.cloud.tweet.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/3/14 19:39
 * @Version 1.0
 **/
@Data
public class QuoteStatusDTO extends StatusDTO{

    @JsonSerialize(using = ToStringSerializer.class)
    private Long quotedStatusId;
}
