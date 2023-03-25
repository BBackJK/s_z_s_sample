package com.example.szs.core.user.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserJpaEntity {
    @Id
    private String userId;
    private String password;
    private String name;
    private String regNo;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private String createdId;
    @UpdateTimestamp
    private LocalDateTime lastUpdatedAt;
    private String lastUpdatedId;

    private LocalDateTime deletedAt;
    private String deletedId;
    private String isDeleted;

}
