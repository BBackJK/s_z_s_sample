package com.example.szs.core.szs.adapter.in.controller.model;

import com.example.szs.infrastructure.web.formatter.NumberCommaFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScrapIncomeCommonDto implements ScrapIncomeResponseDto {

    @JsonProperty(value = "소득구분")
    private String incomeType;
    @JsonProperty(value = "금액")
    @JsonSerialize(using = NumberCommaFormat.class)
    private String amount;
}
