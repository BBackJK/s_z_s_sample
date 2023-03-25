package com.example.szs.core.scrap.adapter.in.controller;

import com.example.szs.common.model.SzsGenericHttpResponse;
import com.example.szs.core.scrap.application.port.in.UserScrapUseCase;
import com.example.szs.core.scrap.domain.szs.ScrapResponseData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ScrapController {

    private final UserScrapUseCase userScrapUseCase;

    @PostMapping("/szs/scrap")
    ResponseEntity<SzsGenericHttpResponse<ScrapResponseData>> testScrap() {
        return ResponseEntity.ok(
                userScrapUseCase.scrap2()
        );
    }
}
