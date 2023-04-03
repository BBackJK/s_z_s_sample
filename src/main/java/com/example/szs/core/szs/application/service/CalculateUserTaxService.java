package com.example.szs.core.szs.application.service;

import com.example.szs.common.utils.BigDecimalUtils;
import com.example.szs.common.utils.CommonUtils;
import com.example.szs.core.szs.adapter.in.controller.model.RefundResponseDto;
import com.example.szs.core.szs.application.port.in.CalculateTaxUseCase;
import com.example.szs.core.szs.application.port.out.LoadUserTaxPort;
import com.example.szs.core.szs.domain.IncomeType;
import com.example.szs.core.szs.domain.UserIncome;
import com.example.szs.core.szs.domain.UserTaxInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
public class CalculateUserTaxService implements CalculateTaxUseCase {

    private final LoadUserTaxPort loadUserTaxPort;

    @Override
    public RefundResponseDto calculate() {
        UserTaxInfo userTax = loadUserTaxPort.loadTaxByUserId("temp");
        // TODO: 데이터 없을 시 Scrap 후 적용

        // 근로소득세액공제금액
        BigDecimal workIncomeTaxAmount = userTax.getOutputTax().calculateWorkIncomeTax();

        // 퇴직연금세액공제금액
        BigDecimal retiredPensionTax = userTax.getIncomeDeductions()
                .stream()
                .filter(userIncome -> CommonUtils.isNotEmpty(userIncome) && IncomeType.isRETPN(userIncome.getIncomeType()))
                .map(UserIncome::calculate)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 특별세액공제금액
        BigDecimal specialTax = userTax.getIncomeDeductions()
                .stream()
                .filter(userIncome -> CommonUtils.isNotEmpty(userIncome) && !IncomeType.isRETPN(userIncome.getIncomeType()))
                .map(UserIncome::calculate)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 특별세액공제금액이 130,000 보다 작은지
        boolean isLessSpecial = specialTax.compareTo(BigDecimalUtils.toBigDecimal("130000")) < 0;

        // 표준세액공제금액
        BigDecimal standardTax = isLessSpecial
                ? BigDecimalUtils.toBigDecimal("130000")
                : BigDecimal.ZERO;

        // 표준세액공제금액이 130,000 이면 ==> 특별세액공제금액이 130,000 보다 작으면 특별세액공제금액을 0원 처리
        specialTax = isLessSpecial ? BigDecimal.ZERO : specialTax;

        // 결정세액
        BigDecimal determinedTax = userTax.getOutputTax().getValue()
                        .subtract(workIncomeTaxAmount)
                        .subtract(specialTax)
                        .subtract(standardTax)
                        .subtract(retiredPensionTax);

        log.info("산출세액 outputTax :: {}", userTax.getOutputTax().getValue());
        log.info("근로소득세액공제금액 workIncomeTaxAmount :: {}", workIncomeTaxAmount);
        log.info("퇴직연금세액공제금액 retiredPensionTax :: {}", retiredPensionTax);
        log.info("특별세액공제금액 specialTax :: {}", specialTax);
        log.info("표준세액공제금액 standardTax :: {}", standardTax);
        log.info("결정세액 determinedTax :: {}", determinedTax);

        return RefundResponseDto.builder()
                .userName("테스트")
                .retiredPensionTax(retiredPensionTax.toString())
                .determinedTaxAmount(determinedTax.compareTo(BigDecimal.ZERO) < 0 ? "0" : determinedTax.toString())
                .build();

    }
}
