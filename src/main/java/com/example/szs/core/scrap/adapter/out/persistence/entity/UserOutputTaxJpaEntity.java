package com.example.szs.core.scrap.adapter.out.persistence.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "user_output_tax")
public class UserOutputTaxJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private BigDecimal outputTax;
    @Column(columnDefinition = "boolean default true")
    private boolean useYn;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
