package com.example.szs.core.log.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiLogRepository extends JpaRepository<ApiLogJpaEntity, Long> {
}
