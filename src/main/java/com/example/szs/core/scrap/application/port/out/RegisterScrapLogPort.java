package com.example.szs.core.scrap.application.port.out;

import com.example.szs.core.scrap.application.port.in.ScrapLogRegisterCommand;

public interface RegisterScrapLogPort {

    void register(ScrapLogRegisterCommand command);
}
