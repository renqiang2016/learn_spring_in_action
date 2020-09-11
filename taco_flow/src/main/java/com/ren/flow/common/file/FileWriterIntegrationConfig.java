package com.ren.flow.common.file;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.support.FileExistsMode;

import java.io.File;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 19:45
 */
@Configuration
public class FileWriterIntegrationConfig {

    @Bean
    public IntegrationFlow fileWriteFlow() {
        return IntegrationFlows.from(MessageChannels.direct("textInChannel"))
                .<String, String>transform(String::toUpperCase)
                .handle(Files.outboundAdapter(new File("."))
                    .fileExistsMode(FileExistsMode.APPEND)
                    .appendNewLine(true))
                .get();
    }
}
