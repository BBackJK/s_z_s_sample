package com.example.szs.core.szs.adapter.in.controller.model;

import com.example.szs.common.format.NumberCommaFormat;
import com.example.szs.common.utils.CommonUtils;
import com.example.szs.common.utils.LocalDateUtils;
import com.example.szs.core.szs.domain.scrap.ScrapSalary;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class ScrapSalaryResponseDto {

    @JsonProperty(value = "소득내역")
    private String incomeDetail;
    @JsonProperty(value = "총지급액")
    @JsonSerialize(using = NumberCommaFormat.class)
    private String totalPayAmount;
    @JsonProperty(value = "업무시작일")
    private String workStartAt;
    @JsonProperty(value = "기업명")
    private String bizName;
    @JsonProperty(value = "이름")
    private String userName;
    @JsonProperty(value = "지급일")
    private String payAt;
    @JsonProperty(value = "업무종료일")
    private String workEndAt;
    @JsonProperty(value = "주민등록번호")
    private String regNo;
    @JsonProperty(value = "소득구분")
    private String incomeType;
    @JsonProperty(value = "사업자등록번호")
    private String bizNo;

    public static ScrapSalaryResponseDto of(ScrapSalary domain) {
        return CommonUtils.isEmpty(domain)
                ? null
                : ScrapSalaryResponseDto.builder()
                .incomeDetail(domain.getIncomeDetail())
                .totalPayAmount(domain.getTotalPayAmount().toString())
                .workStartAt(LocalDateUtils.toString(domain.getWorkStartAt(), DateTimeFormatter.ofPattern(LocalDateUtils.FORMAT_DATE_DOT)))
                .bizName(domain.getBizName())
                .userName(domain.getUserName())
                .payAt(LocalDateUtils.toString(domain.getPayAt(), DateTimeFormatter.ofPattern(LocalDateUtils.FORMAT_DATE_DOT)))
                .workEndAt(LocalDateUtils.toString(domain.getWorkEndAt(), DateTimeFormatter.ofPattern(LocalDateUtils.FORMAT_DATE_DOT)))
                .regNo(domain.getRegNo())
                .incomeType(domain.getIncomeType())
                .bizNo(domain.getBizNo())
                .build();
    }

    public static List<ScrapSalaryResponseDto> of(List<ScrapSalary> domainList) {
        return CommonUtils.isEmpty( domainList )
                ? Collections.emptyList()
                : domainList.stream().map(ScrapSalaryResponseDto::of).collect(Collectors.toList());
    }
}
