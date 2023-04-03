package com.example.szs.core.szs.adapter.out.persistence;

import com.example.szs.common.utils.CommonUtils;
import com.example.szs.core.szs.adapter.out.persistence.entity.UserIncomeJpaEntity;
import com.example.szs.core.szs.adapter.out.persistence.entity.UserOutputTaxJpaEntity;
import com.example.szs.core.szs.adapter.out.persistence.entity.UserSalaryJpaEntity;
import com.example.szs.core.szs.adapter.out.persistence.repositories.UserIncomeRepository;
import com.example.szs.core.szs.adapter.out.persistence.repositories.UserOutputTaxRepository;
import com.example.szs.core.szs.adapter.out.persistence.repositories.UserSalaryRepository;
import com.example.szs.core.szs.application.port.out.LoadUserTaxPort;
import com.example.szs.core.szs.application.port.out.RegisterUserScrapPort;
import com.example.szs.core.szs.domain.UserSalary;
import com.example.szs.core.szs.domain.UserTaxInfo;
import com.example.szs.core.szs.domain.scrap.ScrapUserInfo;
import com.example.szs.infrastructure.annotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
@Slf4j
public class UserScrapPersistenceAdapter implements RegisterUserScrapPort, LoadUserTaxPort {

    private final UserIncomeRepository userIncomeRepository;
    private final UserOutputTaxRepository userOutputTaxRepository;
    private final UserSalaryRepository userSalaryRepository;

    private final UserScrapMapHelper userScrapMapHelper;

    @Override
    public void save(ScrapUserInfo scrapInfo) {
        UserOutputTaxJpaEntity outputTax = userOutputTaxRepository.findByUserIdAndUseYn("temp", true);

        if (CommonUtils.isNotEmpty(outputTax)) {
            outputTax.setUseYn(false);
            userOutputTaxRepository.save(outputTax);
        }

        userOutputTaxRepository.save(
                userScrapMapHelper.toEntity(
                        scrapInfo.getOutputTax()
                )
        );

        List<UserIncomeJpaEntity> incomeList = userIncomeRepository.findByUserIdAndUseYn("temp", true);

        if ( !incomeList.isEmpty() ) {
            incomeList.forEach(income -> income.setUseYn(false));
            userIncomeRepository.saveAll(incomeList);
        }

        userIncomeRepository.saveAll(
                userScrapMapHelper.toEntity(
                        scrapInfo.getIncomes()
                )
        );

        List<UserSalaryJpaEntity> salaryList = userSalaryRepository.findByUserIdAndUseYn("temp", true);

        if ( !salaryList.isEmpty() ) {
            salaryList.forEach(salary -> salary.setUseYn(false));
            userSalaryRepository.saveAll(salaryList);
        }

        userSalaryRepository.saveAll(
                userScrapMapHelper.toSalaryEntity(
                        scrapInfo.getSalaries()
                )
        );
    }

    @Override
    public UserTaxInfo loadTaxByUserId(String userId) {
        UserOutputTaxJpaEntity output = userOutputTaxRepository.findByUserIdAndUseYn(userId, true);
        List<UserIncomeJpaEntity> incomeList = userIncomeRepository.findByUserIdAndUseYn(userId, true);
        List<UserSalaryJpaEntity> salaryList = userSalaryRepository.findByUserIdAndUseYn(userId, true);

        UserSalary userSalary = userScrapMapHelper.toDomain(salaryList);

        return new UserTaxInfo(
                userSalary
                , userScrapMapHelper.toDomain(output)
                , userScrapMapHelper.toIncomeDomainList(incomeList, userSalary)
        );
    }
}
