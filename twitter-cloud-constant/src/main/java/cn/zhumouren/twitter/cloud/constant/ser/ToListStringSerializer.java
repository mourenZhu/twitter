package cn.zhumouren.twitter.cloud.constant.ser;

import cn.zhumouren.twitter.cloud.constant.utils.list.ListUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.List;

/**
 * @Description todo
 * @Author mourenZhu
 * @Date 2021/2/25 14:12
 * @Version 1.0
 **/
public class ToListStringSerializer extends JsonSerializer<List<Long>> {


    @Override
    public void serialize(List<Long> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(ListUtils.toStringList(value));
    }
}
