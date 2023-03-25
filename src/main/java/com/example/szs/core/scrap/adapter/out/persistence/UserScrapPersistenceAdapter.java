package com.example.szs.core.scrap.adapter.out.persistence;

import com.example.szs.core.scrap.adapter.out.persistence.entity.UserIncomeJpaEntity;
import com.example.szs.core.scrap.adapter.out.persistence.repositories.UserIncomeRepository;
import com.example.szs.core.scrap.application.port.in.ScrapLogRegisterCommand;
import com.example.szs.core.scrap.application.port.out.RegisterScrapLogPort;
import com.example.szs.core.scrap.application.port.out.RegisterUserScrapPort;
import com.example.szs.core.scrap.domain.szs.ScrapJsonList;
import com.example.szs.infrastructure.annotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
@Slf4j
public class UserScrapPersistenceAdapter implements RegisterUserScrapPort {

    private final UserIncomeRepository userIncomeRepository;

    private final UserScrapMapHelper userScrapMapHelper;

    @Override
    public void save(ScrapJsonList userScrapInfo) {
        List<UserIncomeJpaEntity> incomeList = userIncomeRepository.findByUserIdAndUseYn("temp", true);

        if ( !incomeList.isEmpty() ) {
            incomeList.forEach(income -> income.setUseYn(false));
            userIncomeRepository.saveAll(incomeList);
        }

        userIncomeRepository.saveAll(
                userScrapMapHelper.incomeToSaveEntity(
                        userScrapInfo.getIncomeDeductions()
                )
        );
    }
}
