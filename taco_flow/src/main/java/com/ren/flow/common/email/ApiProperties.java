package com.ren.flow.common.email;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 21:43
 */
@Data
@ConfigurationProperties(prefix = "taco.api")
@Component
public class ApiProperties {
    private String url;
}
