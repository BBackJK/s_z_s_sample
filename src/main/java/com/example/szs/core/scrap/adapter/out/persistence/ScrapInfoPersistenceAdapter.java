package com.example.szs.core.scrap.adapter.out.persistence;


import com.example.szs.core.scrap.adapter.out.persistence.repositories.ScrapLogRepository;
import com.example.szs.core.scrap.application.port.in.ScrapLogRegisterCommand;
import com.example.szs.core.scrap.application.port.out.RegisterScrapLogPort;
import com.example.szs.infrastructure.annotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class ScrapInfoPersistenceAdapter implements RegisterScrapLogPort {

    private final ScrapLogMapHelper scrapLogMapHelper;
    private final ScrapLogRepository scrapLogRepository;

    @Override
    public void register(ScrapLogRegisterCommand command) {
        scrapLogRepository.save(
            scrapLogMapHelper.commandToEntity(command)
        );
    }

}
