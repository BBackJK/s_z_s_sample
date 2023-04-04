package com.example.szs.core.user.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class UserJpaEntity {
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

    @Column(columnDefinition = "boolean default true")
    private boolean isDeleted;

}
