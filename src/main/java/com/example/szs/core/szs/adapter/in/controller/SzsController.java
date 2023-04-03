package com.example.szs.core.szs.adapter.in.controller;

import com.example.szs.common.model.SzsGenericHttpResponse;
import com.example.szs.core.szs.adapter.in.controller.model.RefundResponseDto;
import com.example.szs.core.szs.adapter.in.controller.model.ScrapResponseDto;
import com.example.szs.core.szs.application.port.in.CalculateTaxUseCase;
import com.example.szs.core.szs.application.port.in.UserScrapUseCase;
import com.example.szs.core.szs.domain.scrap.ScrapResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SzsController {

    private final UserScrapUseCase userScrapUseCase;
    private final CalculateTaxUseCase calculateTaxUseCase;

    @PostMapping("/szs/scrap")
    ScrapResponseDto testScrap() {
        SzsGenericHttpResponse<ScrapResponse> response = userScrapUseCase.scrap();
        return ScrapResponseDto.of(
                response
        );
    }

    @GetMapping("/szs/refund")
    RefundResponseDto testRefund() {
        return calculateTaxUseCase.calculate();
    }
}
