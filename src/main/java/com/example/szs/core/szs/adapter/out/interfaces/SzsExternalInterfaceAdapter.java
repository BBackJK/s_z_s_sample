package com.example.szs.core.szs.adapter.out.interfaces;

import com.example.szs.common.model.SzsGenericHttpResponse;
import com.example.szs.core.szs.adapter.out.interfaces.model.ScrapResponseJsonModel;
import com.example.szs.core.szs.application.port.out.FetchSzsUserScrapGatewayPort;
import com.example.szs.core.szs.application.port.out.SzsScrapRequestPayload;
import com.example.szs.core.szs.domain.scrap.ScrapResponse;
import com.example.szs.infrastructure.annotations.ExtraInterfaceAdapter;
import kong.unirest.GenericType;
import kong.unirest.JsonObjectMapper;
import kong.unirest.UnirestInstance;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@ExtraInterfaceAdapter
@RequiredArgsConstructor
@Slf4j
public class SzsExternalInterfaceAdapter implements FetchSzsUserScrapGatewayPort {
    private final UnirestInstance szsWebService;
    private final JsonObjectMapper unirestJsonObjectMapper;
    private final SzsDomainJsonMapHelper szsDomainJsonMapHelper;

    @Override
    public SzsGenericHttpResponse<ScrapResponse> fetchSzsScrap(SzsScrapRequestPayload payload) {
        String jsonString = szsWebService.post("/v2/scrap").body(payload).asString().getBody();
        SzsGenericHttpResponse<ScrapResponseJsonModel> responseModel = unirestJsonObjectMapper.readValue(jsonString, new GenericType<>(){});

        log.info("{}", responseModel);

        return new SzsGenericHttpResponse<>(
                responseModel.getStatus()
                , szsDomainJsonMapHelper.toDomain(responseModel.getData())
                , responseModel.getErrors()
        );
    }
}
