package com.example.szs.core.user.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
class User {
    String userId;
    String name;
    String password;
    String regNo;

    public static User of(String userId, String name, String password, String regNo) {
        return new User(
            userId
            , name
            , password
            , regNo
        );
    }


}
