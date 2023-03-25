package com.example.szs.core.user.domain.deduction;

import java.math.BigDecimal;

/**
 * 근로소득공제
 */
public class WorkTaxDeduction implements Tax {

    @Override
    public BigDecimal calculate() {
        // 산출세액 * 0.55
        return null;
    }
}
