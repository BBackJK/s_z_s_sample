package com.example.szs.core.log.application.service;

import com.example.szs.core.log.application.port.in.AddApiLogUseCase;
import com.example.szs.core.log.application.port.in.ApiLogAddCommand;
import com.example.szs.core.log.application.port.out.AddApiLogPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiLogService implements AddApiLogUseCase {

    private final AddApiLogPort addApiLogPort;

    @Override
    public void save(ApiLogAddCommand command) {
        addApiLogPort.register(command);
    }
}
