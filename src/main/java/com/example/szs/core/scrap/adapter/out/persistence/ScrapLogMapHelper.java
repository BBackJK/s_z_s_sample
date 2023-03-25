package com.example.szs.core.scrap.adapter.out.persistence;

import com.example.szs.core.scrap.adapter.out.persistence.entity.ScrapLogJpaEntity;
import com.example.szs.core.scrap.application.port.in.ScrapLogRegisterCommand;
import com.example.szs.infrastructure.annotations.DomainMapHelper;

@DomainMapHelper
public class ScrapLogMapHelper {

    ScrapLogJpaEntity commandToEntity(ScrapLogRegisterCommand command) {
        return new ScrapLogJpaEntity(
                null
                , command.getUrl()
                , command.getHttpMethod()
                , command.getRequestInfo()
                , command.getResponseInfo()
                , command.isResult()
                , command.getFailCause()
                , command.getRequestAt()
                , command.getResponseAt()
        );
    }
}
