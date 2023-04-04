package com.example.szs.core.user.domain;

import com.example.szs.infrastructure.encrypt.PasswordEncryptor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@RequiredArgsConstructor
public class User {
    String userId;
    String name;
    String password;
    String regNo;
    LocalDateTime createdAt;
    String createdId;
    LocalDateTime lastUpdatedAt;
    String lastUpdatedId;
    LocalDateTime deletedAt;
    String deletedId;
    boolean isDeleted;

    public static User of(String userId, String name, String password, String regNo) {
        return new User(
                userId
                , name
                , password
                , regNo
                , null
                , userId
                , null
                , userId
                , null
                , null
                , false
        );
    }

}
