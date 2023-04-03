package com.example.szs.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("szs-test")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI springOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title(" 테스트 OPEN API ")
                        .description("테스트입니다.")
                        .version("0.0.1")
                );
    }
}
