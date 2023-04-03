package com.example.szs.core.szs.adapter.in.controller.model;

import com.example.szs.common.utils.CommonUtils;
import com.example.szs.core.szs.domain.scrap.ScrapResponse;
import lombok.*;

@Getter
@Setter
@Builder
public class ScrapDataResponseDto {

    private ScrapJsonListResponseDto jsonList;
    private String appVer;
    private String errMsg;
    private String company;
    private String svcCd;
    private String hostNm;
    private String workerReqDt;
    private String workerResDt;

    public static ScrapDataResponseDto of(ScrapResponse res) {
        return CommonUtils.isEmpty(res)
                ? null
                : ScrapDataResponseDto.builder()
                        .jsonList(ScrapJsonListResponseDto.of(res.getScrapUserInfo()))
                        .appVer(res.getAppVer())
                        .errMsg(res.getErrMsg())
                        .company(res.getCompany())
                        .svcCd(res.getSvcCd())
                        .hostNm(res.getHostNm())
                        .workerReqDt(res.getWorkerReqDt())
                        .workerResDt(res.getWorkerResDt())
                        .build();
    }
}
