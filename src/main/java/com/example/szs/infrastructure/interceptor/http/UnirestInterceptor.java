package com.example.szs.infrastructure.interceptor.http;

import com.example.szs.common.utils.CommonUtils;
import com.example.szs.core.scrap.application.port.in.AddScrapLogUseCase;
import com.example.szs.core.scrap.application.port.in.ScrapLogRegisterCommand;
import kong.unirest.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;


@Slf4j
@RequiredArgsConstructor
public class UnirestInterceptor implements Interceptor {

    private final AddScrapLogUseCase addScrapLogUseCase;
    private final String KONG_REQ_BODY_BREAK_VALUE = "===================================";
    private LocalDateTime requestAt = null;

    public void onRequest(HttpRequest<?> request, Config config) {
        this.requestAt = LocalDateTime.now();
    }

    public void onResponse(HttpResponse<?> response, HttpRequestSummary request, Config config) {
        String[] summaryKeyValue = request.asString().split(KONG_REQ_BODY_BREAK_VALUE + "\n");
        String requestBodyInfo = "EMPTY";
        if ( summaryKeyValue.length >= 2 ) {
            requestBodyInfo = summaryKeyValue[1];
        }
        String responseBody = CommonUtils.isEmpty(response.getBody()) ? null : response.getBody().toString();
        response.getParsingError().ifPresent(e -> {
            log.info("parsing Error !!");
            log.info(e.getCause().getMessage());
        });
        addScrapLogUseCase.save(
                ScrapLogRegisterCommand.builder()
                        .url(request.getUrl())
                        .httpMethod(request.getHttpMethod().toString())
                        .requestInfo(requestBodyInfo)
                        .result(response.isSuccess())
                        .responseInfo(responseBody)
                        .failCause(response.isSuccess() ? null : responseBody)
                        .requestAt(this.requestAt)
                        .responseAt(LocalDateTime.now())
                        .build()
        );
    }
}
