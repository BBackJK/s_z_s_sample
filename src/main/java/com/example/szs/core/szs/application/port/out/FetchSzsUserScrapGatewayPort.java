package com.example.szs.core.szs.application.port.out;


import com.example.szs.common.model.SzsGenericHttpResponse;
import com.example.szs.core.szs.domain.scrap.ScrapResponse;

public interface FetchSzsUserScrapGatewayPort {

    SzsGenericHttpResponse<ScrapResponse> fetchSzsScrap(SzsScrapRequestPayload payload);
}
