package com.example.szs.core.scrap.application.service;

import com.example.szs.core.scrap.application.port.in.AddScrapLogUseCase;
import com.example.szs.core.scrap.application.port.in.ScrapLogRegisterCommand;
import com.example.szs.core.scrap.application.port.out.RegisterScrapLogPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScrapInfoService implements AddScrapLogUseCase {

    private final RegisterScrapLogPort registerScrapLogPort;

    @Override
    public void save(ScrapLogRegisterCommand command) {
        registerScrapLogPort.register(command);
    }
}
