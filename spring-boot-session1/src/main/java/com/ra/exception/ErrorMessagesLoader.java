package com.ra.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

@Configuration
public class ErrorMessagesLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorMessagesLoader.class);
    private static Map<String, Messages> errorMessagesMap;

    public ErrorMessagesLoader() {
        try {
            // Đọc thông báo lỗi tiếng anh
            Properties messagesEN = new Properties();
            messagesEN.load(new InputStreamReader(getClass().getResourceAsStream("/messages_en.properties"), StandardCharsets.UTF_8));
            errorMessagesMap = messagesEN.entrySet().stream().collect(Collectors.toMap(
                    e -> e.getKey().toString(),
                    e -> {
                        Messages messages = new Messages();
                        messages.setEn(e.getValue().toString());
                        return messages;
                    }
            ));
            // Đọc thông báo lỗi tiếng việt
            Properties messagesVN = new Properties();
            messagesEN.load(new InputStreamReader(getClass().getResourceAsStream("/messages_vn.properties"), StandardCharsets.UTF_8));
            errorMessagesMap.forEach((key, value) -> value.setVn(messagesVN.getProperty(key)));
            LOGGER.info("ErrorMessagesLoader load messages successfully!");
        } catch (Exception ex) {
            LOGGER.error("ErrorMessagesLoader load messages with ex: {}", ex);
        }
    }

    public Messages getMessages(String errorCode) {
        Messages messages = errorMessagesMap.get(errorCode);
        if (messages == null) {
            messages = new Messages();
            messages.setEn("Internal server error!");
            messages.setVn("Lỗi hệ thống!");
        }
        return messages;
    }
}
