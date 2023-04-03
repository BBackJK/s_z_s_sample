package com.example.szs.core.szs.adapter.out.interfaces.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ScrapResponseJsonModel {
    private ScrapJsonListJsonModel jsonList;
    private String appVer;
    private String errMsg;
    private String company;
    private String svcCd;
    private String hostNm;
    private String workerResDt;
    private String workerReqDt;
}
