package com.example.szs.core.user.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user_white_list")
@NoArgsConstructor
@AllArgsConstructor
public class UserWhiteListJpaEntity {
    @Id
    private String regNo;
    private String name;
}
