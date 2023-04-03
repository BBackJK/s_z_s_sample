package com.example.szs.core.log.application.port.out;

import com.example.szs.core.log.application.port.in.ApiLogAddCommand;

public interface AddApiLogPort {

    void register(ApiLogAddCommand command);
}
