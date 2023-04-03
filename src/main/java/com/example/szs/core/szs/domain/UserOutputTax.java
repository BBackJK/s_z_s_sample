package com.example.szs.core.szs.domain;

import com.example.szs.common.utils.BigDecimalUtils;
import com.example.szs.common.utils.CommonUtils;
import lombok.Value;

import java.math.BigDecimal;

/**
 * 산출세액
 */
@Value
public class UserOutputTax {

    BigDecimal value;

    public static UserOutputTax of(String outputTaxValueString) {
        return new UserOutputTax(
                new BigDecimal(outputTaxValueString)
        );
    }

    public BigDecimal calculateWorkIncomeTax() {
        return CommonUtils.isEmpty(value)
                ? BigDecimal.ZERO
                : value.multiply(BigDecimalUtils.toBigDecimal("0.55"));
    }
}
