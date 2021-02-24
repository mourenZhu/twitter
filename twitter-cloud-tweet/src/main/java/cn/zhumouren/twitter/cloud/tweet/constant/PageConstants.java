package cn.zhumouren.twitter.cloud.tweet.constant;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description 分页配置
 * @Author mourenZhu
 * @Date 2021/1/28 17:19
 * @Version 1.0
 **/
@Component
@PropertySource("classpath:config/constant.properties")
@ConfigurationProperties(prefix = "constant.page")
@EnableConfigurationProperties({PageConstants.class})
public class PageConstants {

    private static Integer current = 1;

    private static Integer size = 20;

    public static Page constantPageConfig(Page page, Integer current, Integer size) {
        if (null == current || null == size) {
            page.setCurrent(PageConstants.current);
            page.setSize(PageConstants.size);
        } else {
            page.setCurrent(current);
            page.setSize(size);
        }
        return page;
    }

    public void setCurrent(Integer current) {
        PageConstants.current = current;
    }

    public void setSize(Integer size) {
        PageConstants.size = size;
    }
}
