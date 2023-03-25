package com.example.szs.core.scrap.adapter.out.interfaces;

import com.example.szs.common.model.SzsGenericHttpResponse;
import com.example.szs.core.scrap.application.port.out.FetchSzsUserScrapGatewayPort;
import com.example.szs.core.scrap.application.port.out.SzsScrapRequestPayload;
import com.example.szs.core.scrap.domain.szs.ScrapResponseData;
import com.example.szs.infrastructure.annotations.ExtraInterfaceAdapter;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
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

    @Override
    public SzsGenericHttpResponse<ScrapResponseData> fetchSzsScrap(SzsScrapRequestPayload payload) {
        String response = szsWebService.post("/v2/scrap").body(payload).asString().getBody();
        return unirestJsonObjectMapper.readValue(response, new GenericType<>(){});
    }
}
