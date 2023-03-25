package com.example.szs.core.scrap.application.port.in;

import com.example.szs.common.model.SzsGenericHttpResponse;
import com.example.szs.core.scrap.domain.szs.ScrapResponseData;

public interface UserScrapUseCase {

    String scrap();

    SzsGenericHttpResponse<ScrapResponseData> scrap2();
}
