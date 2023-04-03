package com.example.szs.core.szs.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@RequiredArgsConstructor
public class UserTaxInfo {

    UserSalary salary;  // 급여정보
    UserOutputTax outputTax;    // 산출세액
    List<UserIncome> incomeDeductions; // 소득공제목록
}
