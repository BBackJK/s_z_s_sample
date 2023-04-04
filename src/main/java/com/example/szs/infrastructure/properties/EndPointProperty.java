package com.example.szs.infrastructure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "end-point")
@Data
public class EndPointProperty {
    private String szsCodeTest;
}
