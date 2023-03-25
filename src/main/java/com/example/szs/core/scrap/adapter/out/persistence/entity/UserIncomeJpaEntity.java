package com.example.szs.core.scrap.adapter.out.persistence.entity;

import com.example.szs.core.scrap.domain.IncomeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "user_income")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserIncomeJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private BigDecimal amount;
    @Column(columnDefinition = "boolean default true")
    private boolean useYn;
//    @Enumerated(EnumType.STRING)
//    private IncomeType incomeType;

    private String incomeType;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
