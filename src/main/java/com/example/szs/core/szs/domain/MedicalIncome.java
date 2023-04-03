package com.example.szs.core.szs.domain;

import com.example.szs.common.utils.BigDecimalUtils;
import com.example.szs.common.utils.CommonUtils;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class MedicalIncome implements SpecialMedicalIncome{

    BigDecimal amount;
    IncomeType incomeType;
    BigDecimal totalPayAmount;

    // 의료비 - 총급여 * 3% (의료비 < 0일 경우 의료비 = 0처리)
    @Override
    public BigDecimal calculate() {
        if (CommonUtils.orEmpty(amount, totalPayAmount, incomeType)) {
            return BigDecimal.ZERO;
        }
        BigDecimal totalPayAmountIncome = this.totalPayAmount.multiply(BigDecimalUtils.toBigDecimal("0.03"));
        BigDecimal midMedicalIncome = this.amount.subtract(totalPayAmountIncome);
        BigDecimal medicalIncome = midMedicalIncome.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : midMedicalIncome;
        return medicalIncome.multiply(BigDecimalUtils.toBigDecimal("0.15"));
    }
}
