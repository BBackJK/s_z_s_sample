package com.example.szs.core.log.adapter.out.persistence;


import com.example.szs.core.log.application.port.in.ApiLogAddCommand;
import com.example.szs.core.log.application.port.out.AddApiLogPort;
import com.example.szs.infrastructure.annotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class ApiLogPersistenceAdapter implements AddApiLogPort {

    private final ApiLogMapHelper apiLogMapHelper;
    private final ApiLogRepository apiLogRepository;

    @Override
    public void register(ApiLogAddCommand command) {
        apiLogRepository.save(
                apiLogMapHelper.commandToEntity(command)
        );
    }

}
