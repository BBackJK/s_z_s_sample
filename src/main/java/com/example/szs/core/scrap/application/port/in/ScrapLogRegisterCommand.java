package com.example.szs.core.scrap.application.port.in;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ScrapLogRegisterCommand {

    private String url;
    private String httpMethod;
    private String requestInfo;
    private String responseInfo;
    private boolean result;
    private String failCause;

    private LocalDateTime requestAt;
    private LocalDateTime responseAt;
}
