package com.example.szs.core.szs.adapter.out.persistence.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "user_output_tax")
@AllArgsConstructor
@NoArgsConstructor
@Data
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
