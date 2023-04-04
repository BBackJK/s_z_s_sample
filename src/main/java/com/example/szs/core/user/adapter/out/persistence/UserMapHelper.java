package com.example.szs.core.user.adapter.out.persistence;

import com.example.szs.common.utils.CommonUtils;
import com.example.szs.core.user.domain.User;
import com.example.szs.infrastructure.annotations.DomainMapHelper;

@DomainMapHelper
class UserMapHelper {

    UserJpaEntity toEntity(User domain) {
        if ( CommonUtils.isEmpty(domain) ) return null;
        return new UserJpaEntity(
                domain.getUserId()
                , domain.getPassword()
                , domain.getName()
                , domain.getRegNo()
                , domain.getCreatedAt()
                , domain.getCreatedId()
                , domain.getLastUpdatedAt()
                , domain.getLastUpdatedId()
                , domain.getDeletedAt()
                , domain.getDeletedId()
                , domain.isDeleted()
        );
    }
}
