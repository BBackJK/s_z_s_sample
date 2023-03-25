package com.example.szs.core.scrap.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "scrap_log")
@NoArgsConstructor
@AllArgsConstructor
public class ScrapLogJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String httpMethod;
    @Column(columnDefinition = "LONGTEXT")
    private String requestInfo;
    @Column(columnDefinition = "LONGTEXT")
    private String responseInfo;
    private boolean result;
    @Column(columnDefinition = "LONGTEXT")
    private String failCause;
    private LocalDateTime requestAt;
    private LocalDateTime responseAt;

}
