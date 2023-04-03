package com.example.szs.core.szs.domain;

import java.math.BigDecimal;

public interface SpecialMedicalIncome extends UserIncome {
    BigDecimal getTotalPayAmount();
}
