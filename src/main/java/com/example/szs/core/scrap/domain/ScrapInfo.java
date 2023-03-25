package com.example.szs.core.scrap.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@RequiredArgsConstructor
public class ScrapInfo {

    Salary salary;  // 급여정보
    OutputTax outputTax;    // 산출세액
    List<IncomeDeduction> incomeDeductions; // 소득공제목록
}
