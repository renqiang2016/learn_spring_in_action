package com.ren.flow.common.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.mail.dsl.Mail;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 21:37
 */
@Configuration
public class TacoOrderEmailIntegrationConfig {

    @Bean
    public IntegrationFlow tacoOrderEmailFlow(
            EmailProperties emailProps,
            EmailToOrderTransformer emailToOrderTransformer,
            OrderSubmitMessageHandler orderSubmitHandler) {

        return IntegrationFlows
                .from(Mail.imapInboundAdapter(emailProps.getImapUrl()),
                        e -> e.poller(
                                Pollers.fixedDelay(emailProps.getPollRate())))
                .transform(emailToOrderTransformer)
                .handle(orderSubmitHandler)
                .get();
    }

}
