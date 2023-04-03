package com.example.szs.core.szs.application.port.out;

import com.example.szs.core.szs.domain.UserTaxInfo;

public interface LoadUserTaxPort {

    UserTaxInfo loadTaxByUserId(String userId);
}
