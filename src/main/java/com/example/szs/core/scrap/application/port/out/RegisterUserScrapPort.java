package com.example.szs.core.scrap.application.port.out;

import com.example.szs.core.scrap.domain.szs.ScrapJsonList;

public interface RegisterUserScrapPort {
    void save(ScrapJsonList userScrapInfo);
}
