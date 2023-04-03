package com.example.szs.core.log.adapter.out.persistence;

import com.example.szs.core.log.application.port.in.ApiLogAddCommand;
import com.example.szs.infrastructure.annotations.DomainMapHelper;

@DomainMapHelper
public class ApiLogMapHelper {

    ApiLogJpaEntity commandToEntity(ApiLogAddCommand command) {
        return new ApiLogJpaEntity(
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
