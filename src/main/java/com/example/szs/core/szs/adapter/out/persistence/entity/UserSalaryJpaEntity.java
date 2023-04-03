package com.example.szs.core.szs.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "user_salary")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSalaryJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String incomeType; // 소득구분
    private String incomeDetail; //소득내역
    private BigDecimal totalPayAmount; // 총지급액
    private LocalDate workStartAt; // 업무시작일
    private LocalDate workEndAt; // 업무종료일
    private String bizName; // 회사명
    private LocalDate payAt; // 지급일
    private String regNo; // 주민등록번호
    private String bizNo; // 사업자등록번호
    @Column(columnDefinition = "boolean default true")
    private boolean useYn;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
