package com.example.szs.core.szs.domain.scrap;

import com.example.szs.core.szs.domain.IncomeType;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
@RequiredArgsConstructor
public class ScrapIncome {

    IncomeType incomeType;  // 소득구분
    BigDecimal amount;      // 총지급액

    public static ScrapIncome of(IncomeType incomeType, BigDecimal amount) {
        return new ScrapIncome(
                incomeType
                , amount
        );
    }
}
