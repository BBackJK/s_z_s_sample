package com.example.szs.core.scrap.adapter.out.persistence;

import com.example.szs.common.utils.BigDecimalUtils;
import com.example.szs.common.utils.CommonUtils;
import com.example.szs.common.utils.LocalDateUtils;
import com.example.szs.core.scrap.adapter.out.persistence.entity.UserIncomeJpaEntity;
import com.example.szs.core.scrap.adapter.out.persistence.entity.UserSalaryJpaEntity;
import com.example.szs.core.scrap.domain.szs.ScrapIncomeDeduction;
import com.example.szs.core.scrap.domain.szs.ScrapSalary;
import com.example.szs.infrastructure.annotations.DomainMapHelper;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@DomainMapHelper
@Slf4j
public class UserScrapMapHelper {

    UserSalaryJpaEntity salaryToSaveEntity(ScrapSalary domain) {
        return new UserSalaryJpaEntity(
                null
                , "temp"
                , domain.getIncomeType()
                , domain.getIncomeDetail()
                , BigDecimalUtils.toBigDecimal(CommonUtils.orElse(domain.getTotalPayAmount(), "").replaceAll(",", ""))
                , LocalDateUtils.toLocalDate(domain.getWorkStartAt(), DateTimeFormatter.ofPattern(LocalDateUtils.FORMAT_DATE_DOT))
                , LocalDateUtils.toLocalDate(domain.getWorkEndAt(), DateTimeFormatter.ofPattern(LocalDateUtils.FORMAT_DATE_DOT))
                , domain.getBizName()
                , LocalDateUtils.toLocalDate(domain.getPayAt(), DateTimeFormatter.ofPattern(LocalDateUtils.FORMAT_DATE_DOT))
                , domain.getRegNo()
                , domain.getBizNo()
                , true
                , LocalDateTime.now()
        );
    }

    List<UserSalaryJpaEntity> salaryToSaveEntity(List<ScrapSalary> domainList) {
        if (CommonUtils.isEmpty(domainList)) return Collections.emptyList();
        return domainList.stream().map(this::salaryToSaveEntity).collect(Collectors.toList());
    }

    UserIncomeJpaEntity incomeToSaveEntity(ScrapIncomeDeduction domain) {
        return new UserIncomeJpaEntity(
                null
                , "temp"
                , BigDecimalUtils.toBigDecimal(CommonUtils.orElse(domain.getAmount(), "").replaceAll(",", ""))
                , true
                , domain.getIncomeType()
                , LocalDateTime.now()
        );
    }

    List<UserIncomeJpaEntity> incomeToSaveEntity(List<ScrapIncomeDeduction> domainList) {
        if ( CommonUtils.isEmpty(domainList) ) return Collections.emptyList();
        return domainList.stream().map(this::incomeToSaveEntity).collect(Collectors.toList());
    }
}
