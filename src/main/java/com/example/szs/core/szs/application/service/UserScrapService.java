package com.example.szs.core.szs.application.service;

import com.example.szs.common.model.SzsGenericHttpResponse;
import com.example.szs.common.utils.CommonUtils;
import com.example.szs.core.szs.application.port.in.UserScrapUseCase;
import com.example.szs.core.szs.application.port.out.FetchSzsUserScrapGatewayPort;
import com.example.szs.core.szs.application.port.out.RegisterUserScrapPort;
import com.example.szs.core.szs.application.port.out.SzsScrapRequestPayload;
import com.example.szs.core.szs.domain.scrap.ScrapResponse;
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
    public SzsGenericHttpResponse<ScrapResponse> scrap() {
        SzsGenericHttpResponse<ScrapResponse> response = fetchSzsUserScrapGatewayPort.fetchSzsScrap(new SzsScrapRequestPayload("홍길동", "860824-1655068"));
        if ( CommonUtils.orEmpty( response, response.getData() ) || !response.isSuccess() ) {
            throw new RuntimeException(" 응답이 실패했습니다. "); // TODO: CustomException 추가 및 ExceptionHandler 적용
        }

        if ( !CommonUtils.orEmpty(response.getData(), response.getData().getScrapUserInfo()) ) {
            registerUserScrapPort.save(response.getData().getScrapUserInfo());
        }

        return response;
    }
}
