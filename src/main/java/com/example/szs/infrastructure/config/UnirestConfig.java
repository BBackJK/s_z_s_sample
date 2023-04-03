package com.example.szs.infrastructure.config;

import com.example.szs.core.log.application.port.in.AddApiLogUseCase;
import com.example.szs.infrastructure.interceptor.http.UnirestInterceptor;
import kong.unirest.Config;
import kong.unirest.Unirest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UnirestConfig {
    private final AddApiLogUseCase addScrapLogUseCase;

    @Bean
    public UnirestInterceptor getUnirestInterceptor() {
        return new UnirestInterceptor(addScrapLogUseCase);
    }

    @Bean
    public Config unirestGlobalConfig() {
        return Unirest.config()
                .setDefaultHeader("Accept", "application/json")
                .interceptor(getUnirestInterceptor())
                ;
    }

}
