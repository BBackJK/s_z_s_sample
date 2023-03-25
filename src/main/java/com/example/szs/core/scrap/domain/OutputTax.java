package com.example.szs.core.scrap.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;

/**
 * 산출세액
 */
@Value
@AllArgsConstructor
public class OutputTax {

    BigDecimal value;

    public static OutputTax of(String outputTaxValueString) {
        return new OutputTax(
                new BigDecimal(outputTaxValueString)
        );
    }

    // 근로소득세액공제금액 = 산축세액 * 0.55
    public BigDecimal calculationWorkDeductionRate() {
        return value.multiply(
                new BigDecimal("0.55")
        );
    }
}
