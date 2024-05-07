package com.backend.programming.learning.system.auth.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "keycloak")
public class KeycloakConfigData {
    private String realm;
    private String domain;
    private String client;
    private String urls;
    private String adminClientId;
    private String adminClientSecret;
}
