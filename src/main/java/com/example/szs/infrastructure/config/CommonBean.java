package com.example.szs.infrastructure.config;

import com.example.szs.infrastructure.properties.EndPointProperty;
import kong.unirest.Config;
import kong.unirest.JsonObjectMapper;
import kong.unirest.UnirestInstance;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class CommonBean {
    private final EndPointProperty endPointProperty;
    private final Config unirestGlobalConfig;

    @Bean
    public UnirestInstance szsWebService() {
        return new UnirestInstance(
                unirestGlobalConfig
                        .defaultBaseUrl(endPointProperty.getSzsCodeTest())
        );
    }

    @Bean
    public JsonObjectMapper unirestJsonObjectMapper() {
        return new JsonObjectMapper();
    }
}
