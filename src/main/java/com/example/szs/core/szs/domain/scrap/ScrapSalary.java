package com.example.szs.core.szs.domain.scrap;

import com.example.szs.core.szs.domain.IncomeType;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
@RequiredArgsConstructor
public class ScrapSalary {

    String incomeDetail;            // 소득내역
    BigDecimal totalPayAmount;      // 총지급액
    LocalDate workStartAt;          // 업무시작일
    String bizName;                 // 기업명
    String userName;                // 이름
    LocalDate payAt;                // 지급일
    LocalDate workEndAt;            // 업무종료일
    String regNo;                   // 주민등록번호
    String incomeType;              // 소득구분
    String bizNo;                   // 사업자등록번호

    public static ScrapSalary of(String incomeDetail, BigDecimal totalPayAmount, LocalDate workStartAt, String bizName, String userName, LocalDate payAt
                                 , LocalDate workEndAt, String regNo, String incomeType, String bizNo) {
        return new ScrapSalary(
                incomeDetail
                , totalPayAmount
                , workStartAt
                , bizName
                , userName
                , payAt
                , workEndAt
                , regNo
                , incomeType
                , bizNo
        );
    }
}
