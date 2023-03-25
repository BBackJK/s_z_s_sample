package com.example.szs.core.user.domain;

import com.example.szs.common.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
class UserWhiteList {
    String name;
    String regNo;

    public boolean isWhiteUser(User user) {
        if ( CommonUtils.orEmpty(user, user.getName(), user.getRegNo()) ) {
            return false;
        }

        return user.getName().equals(this.name) && user.getRegNo().equals(this.regNo);
    }
}
