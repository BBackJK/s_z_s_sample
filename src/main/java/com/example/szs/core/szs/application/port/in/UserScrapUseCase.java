package com.example.szs.core.szs.application.port.in;


import com.example.szs.common.model.SzsGenericHttpResponse;
import com.example.szs.core.szs.domain.scrap.ScrapResponse;

public interface UserScrapUseCase {

    SzsGenericHttpResponse<ScrapResponse> scrap();
}
