package com.example.szs.core.szs.domain;

import com.example.szs.common.utils.BigDecimalUtils;
import com.example.szs.common.utils.CommonUtils;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class OtherIncome implements SpecialOtherIncome {

    BigDecimal amount;
    IncomeType incomeType;

    @Override
    public BigDecimal calculate() {
        if (CommonUtils.orEmpty(amount, incomeType)) return BigDecimal.ZERO;

        switch ( incomeType ) {
            case INSU:
                return amount.multiply(BigDecimalUtils.toBigDecimal("0.12"));
            case EDU:
            case DONA:
            case RETPN:
                return amount.multiply(BigDecimalUtils.toBigDecimal("0.15"));
            default:
                return BigDecimal.ZERO;
        }
    }
}
