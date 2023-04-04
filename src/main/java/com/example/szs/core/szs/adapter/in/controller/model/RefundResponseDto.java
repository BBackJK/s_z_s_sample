package com.example.szs.core.szs.adapter.in.controller.model;

import com.example.szs.infrastructure.web.formatter.NumberCommaFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RefundResponseDto {

    @JsonProperty(value = "이름")
    private String userName;

    @JsonProperty(value = "결정세액")
    @JsonSerialize(using = NumberCommaFormat.class)
    private String determinedTaxAmount;

    @JsonProperty(value = "퇴직연금세액공제")
    @JsonSerialize(using = NumberCommaFormat.class)
    private String retiredPensionTax;

}
