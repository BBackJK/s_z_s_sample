package com.example.szs.core.szs.adapter.in.controller.model;

import com.example.szs.common.model.SzsGenericHttpResponse;
import com.example.szs.core.szs.domain.scrap.ScrapResponse;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
public class ScrapResponseDto {
    private String status;
    private ScrapDataResponseDto data;
    private Map<String, Object> errors;

    public static ScrapResponseDto of(SzsGenericHttpResponse<ScrapResponse> res) {
        return ScrapResponseDto.builder()
                .status(res.getStatus())
                .data(ScrapDataResponseDto.of(res.getData()))
                .errors(res.getErrors())
                .build();
    }
}
