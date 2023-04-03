package com.example.szs.core.szs.adapter.in.controller.model;

import com.example.szs.common.factory.ScrapIncomeResponseFactory;
import com.example.szs.common.format.NumberCommaFormat;
import com.example.szs.common.utils.CommonUtils;
import com.example.szs.core.szs.domain.scrap.ScrapUserInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class ScrapJsonListResponseDto {

    @JsonProperty(value = "급여")
    List<ScrapSalaryResponseDto> salaries;
    @JsonProperty(value = "산출세액")
    @JsonSerialize(using = NumberCommaFormat.class)
    private String outputTax;
    @JsonProperty(value = "소득공제")
    List<ScrapIncomeResponseDto> incomes;

    public static ScrapJsonListResponseDto of(ScrapUserInfo res) {
        List<ScrapIncomeResponseDto> incomes = CommonUtils.orEmpty(res, res.getIncomes())
                                                ? Collections.emptyList()
                                                : res.getIncomes().stream()
                                                .map(e -> {
                                                    ScrapIncomeResponseDto income = ScrapIncomeResponseFactory.getIncome(e.getIncomeType());
                                                    if (CommonUtils.isEmpty(income)) return null;
                                                    income.setIncomeType(e.getIncomeType().getDescription());
                                                    income.setAmount(e.getAmount().toString());
                                                    return income;
                                                })
                                                .collect(Collectors.toList());
        return CommonUtils.isEmpty(res)
                ? null
                : ScrapJsonListResponseDto.builder()
                    .salaries(ScrapSalaryResponseDto.of(res.getSalaries()))
                    .outputTax(res.getOutputTax().toString())
                    .incomes(incomes)
                    .build();
    }
}
