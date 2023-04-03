package com.example.szs.core.szs.adapter.in.controller.model;

import com.example.szs.common.format.NumberCommaFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScrapIncomeTotalDto implements ScrapIncomeResponseDto {

    @JsonProperty(value = "소득구분")
    private String incomeType;
    @JsonProperty(value = "총납임금액")
    @JsonSerialize(using = NumberCommaFormat.class)
    private String amount;
}
