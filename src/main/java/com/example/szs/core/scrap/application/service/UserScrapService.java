package com.example.szs.core.scrap.application.service;

import com.example.szs.common.model.SzsGenericHttpResponse;
import com.example.szs.common.utils.CommonUtils;
import com.example.szs.core.scrap.application.port.in.UserScrapUseCase;
import com.example.szs.core.scrap.application.port.out.FetchSzsUserScrapGatewayPort;
import com.example.szs.core.scrap.application.port.out.RegisterUserScrapPort;
import com.example.szs.core.scrap.application.port.out.SzsScrapRequestPayload;
import com.example.szs.core.scrap.domain.szs.ScrapResponseData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserScrapService implements UserScrapUseCase {
    private final FetchSzsUserScrapGatewayPort fetchSzsUserScrapGatewayPort;
    private final RegisterUserScrapPort registerUserScrapPort;

    @Override
    public String scrap() {
        String result = fetchSzsUserScrapGatewayPort.fetchSzsScrap(new SzsScrapRequestPayload("홍길동", "860824-1655068")).toString();
        log.info(result);
        return result;
    }

    @Override
    public SzsGenericHttpResponse<ScrapResponseData> scrap2() {
        SzsGenericHttpResponse<ScrapResponseData> response = fetchSzsUserScrapGatewayPort.fetchSzsScrap(new SzsScrapRequestPayload("홍길동", "860824-1655068"));
        if ( response.isSuccess() && CommonUtils.isNotEmpty(response.getData())) {
            registerUserScrapPort.save( response.getData().getJsonList() );
        }
        return response;
    }
}
