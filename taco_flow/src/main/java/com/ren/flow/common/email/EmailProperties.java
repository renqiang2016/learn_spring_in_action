package com.ren.flow.common.email;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 21:16
 */
@Data
@ConfigurationProperties(prefix = "taco.email")
@Component
public class EmailProperties {
    private String username;
    private String password;
    private String host;
    private String mailbox;
    private long pollRate = 30000;

    public String getImapUrl() {
        return String.format("imaps://%s:%s@%s/%s", this.username,
                this.password, this.host, this.mailbox);
    }
}
