package com.ren.flow.common.file;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;


/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 17:29
 */
@MessagingGateway(defaultRequestChannel = "textInChannel")
public interface FileWriterGateway {
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, String data);
}
