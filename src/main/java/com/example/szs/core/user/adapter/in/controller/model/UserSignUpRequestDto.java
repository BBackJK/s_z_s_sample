package com.example.szs.core.user.adapter.in.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSignUpRequestDto {
    private String userId;
    private String password;
    private String name;
    private String regNo;
}
