package com.example.szs.core.szs.domain.scrap;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class ScrapResponse {
    ScrapUserInfo scrapUserInfo;
    String appVer;
    String errMsg;
    String company;
    String svcCd;
    String hostNm;
    String workerResDt;
    String workerReqDt;

    public static ScrapResponse of(
            ScrapUserInfo scrapUserInfo
            , String appVer
            , String errMsg
            , String company
            , String svcCd
            , String hostNm
            , String workerReqDt
            , String workerResDt
    ) {
        return new ScrapResponse(
                scrapUserInfo
                , appVer
                , errMsg
                , company
                , svcCd
                , hostNm
                , workerReqDt
                , workerResDt
        );
    }
}
