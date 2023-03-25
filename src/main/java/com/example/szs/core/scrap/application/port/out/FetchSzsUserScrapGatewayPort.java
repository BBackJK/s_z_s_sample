package com.example.szs.core.scrap.application.port.out;


import com.example.szs.common.model.SzsGenericHttpResponse;
import com.example.szs.core.scrap.domain.szs.ScrapResponseData;

public interface FetchSzsUserScrapGatewayPort {

    SzsGenericHttpResponse<ScrapResponseData> fetchSzsScrap(SzsScrapRequestPayload payload);
}
