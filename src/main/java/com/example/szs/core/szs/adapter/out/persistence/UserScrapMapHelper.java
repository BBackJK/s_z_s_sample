package com.example.szs.core.szs.adapter.out.persistence;

import com.example.szs.common.utils.CommonUtils;
import com.example.szs.core.szs.adapter.out.persistence.entity.UserIncomeJpaEntity;
import com.example.szs.core.szs.adapter.out.persistence.entity.UserOutputTaxJpaEntity;
import com.example.szs.core.szs.adapter.out.persistence.entity.UserSalaryJpaEntity;
import com.example.szs.core.szs.domain.*;
import com.example.szs.core.szs.domain.scrap.ScrapIncome;
import com.example.szs.core.szs.domain.scrap.ScrapSalary;
import com.example.szs.infrastructure.annotations.DomainMapHelper;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@DomainMapHelper
@Slf4j
public class UserScrapMapHelper {

    UserOutputTaxJpaEntity toEntity(BigDecimal outputTax) {
        if (CommonUtils.isEmpty(outputTax)) return null;
        return new UserOutputTaxJpaEntity(
                null
                , "temp"
                , outputTax
                , true
                , LocalDateTime.now()
        );
    }

    UserIncomeJpaEntity toEntity(ScrapIncome domain) {
        if ( CommonUtils.isEmpty(domain) ) return null;
        return new UserIncomeJpaEntity(
                null
                , "temp"
                , domain.getAmount()
                , true
                , domain.getIncomeType()
                , LocalDateTime.now()
        );
    }

    List<UserIncomeJpaEntity> toEntity(List<ScrapIncome> domainList) {
        if (CommonUtils.isEmpty(domainList)) return Collections.emptyList();
        return domainList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    UserSalaryJpaEntity toEntity(ScrapSalary domain) {
        if ( CommonUtils.isEmpty(domain) ) return null;
        return new UserSalaryJpaEntity(
            null
            , "temp"
            , domain.getIncomeType()
            , domain.getIncomeDetail()
            , domain.getTotalPayAmount()
            , domain.getWorkStartAt()
            , domain.getWorkEndAt()
            , domain.getBizName()
            , domain.getPayAt()
            , domain.getRegNo()
            , domain.getBizNo()
            , true
            , LocalDateTime.now()
        );
    }

    List<UserSalaryJpaEntity> toSalaryEntity(List<ScrapSalary> domainList) {
        if (CommonUtils.isEmpty(domainList)) return Collections.emptyList();
        return domainList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    UserSalary toDomain(List<UserSalaryJpaEntity> entities) {
        return new UserSalary(
            entities.stream().map(UserSalaryJpaEntity::getTotalPayAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
        );
    }

    UserOutputTax toDomain(UserOutputTaxJpaEntity entity) {
        return new UserOutputTax(
                CommonUtils.isEmpty(entity) ? BigDecimal.ZERO : entity.getOutputTax()
        );
    }

    UserIncome toDomain(UserIncomeJpaEntity entity, UserSalary salary) {
        if (CommonUtils.isEmpty(entity)) return null;

        switch (entity.getIncomeType()) {
            case MEDIC:
                return new MedicalIncome(
                        entity.getAmount()
                        , entity.getIncomeType()
                        , CommonUtils.isEmpty(salary) ? BigDecimal.ZERO : salary.getTotalPayAmount()
                );
            case INSU:
            case EDU:
            case DONA:
            case RETPN:
                return new OtherIncome(
                        entity.getAmount()
                        , entity.getIncomeType()
                );
            default:
                return null;
        }
    }

    List<UserIncome> toIncomeDomainList(List<UserIncomeJpaEntity> entities, UserSalary salary) {
        return entities.stream().map(e -> toDomain(e, salary)).collect(Collectors.toList());
    }
}

