package com.example.szs.core.scrap.domain;

import lombok.Value;

/**
 *  소득공제
 */
@Value
public class IncomeDeduction {
    String amount; // 금액
    IncomeType type;

    public static IncomeDeduction of(String amount, IncomeType type) {
        return new IncomeDeduction(
                amount
                , type
        );
    }
}
