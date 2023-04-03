package com.example.szs.core.szs.domain.scrap;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
@RequiredArgsConstructor
public class ScrapUserInfo {
    List<ScrapSalary> salaries;
    BigDecimal outputTax;
    List<ScrapIncome> incomes;

    public static ScrapUserInfo of(List<ScrapSalary> salaries, BigDecimal outputTax, List<ScrapIncome> incomes) {
        return new ScrapUserInfo(
                salaries
                , outputTax
                , incomes
        );
    }
}
