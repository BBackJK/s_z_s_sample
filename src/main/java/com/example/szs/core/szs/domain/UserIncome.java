package com.example.szs.core.szs.domain;

import java.math.BigDecimal;

public interface UserIncome {
    BigDecimal getAmount();
    IncomeType getIncomeType();
    BigDecimal calculate();
}
