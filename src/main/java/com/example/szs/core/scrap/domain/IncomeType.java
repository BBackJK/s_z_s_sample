package com.example.szs.core.scrap.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum IncomeType {
    INSU("보험료"),
    EDU("교육비"),
    DONA("기부금"),
    MEDIC("의료비"),
    PENS("퇴직연금");

    private String description;

}
