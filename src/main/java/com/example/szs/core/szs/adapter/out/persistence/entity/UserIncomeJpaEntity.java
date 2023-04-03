package com.example.szs.core.szs.adapter.out.persistence.entity;

import com.example.szs.core.szs.domain.IncomeType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "user_income")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserIncomeJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private BigDecimal amount;
    @Column(columnDefinition = "boolean default true")
    private boolean useYn;
    @Enumerated(EnumType.STRING)
    private IncomeType incomeType;

//    private String incomeType;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
