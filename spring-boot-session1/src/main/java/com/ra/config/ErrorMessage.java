package com.ra.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "error")
public class ErrorMessage {
    //@Value("${error.message}")
    private String message;

    //@Value("${error.login}")
    private String login;

    private boolean auth;

    private List<String> status;
}
