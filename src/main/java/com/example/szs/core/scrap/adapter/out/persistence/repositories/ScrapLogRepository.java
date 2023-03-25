package com.example.szs.core.scrap.adapter.out.persistence.repositories;

import com.example.szs.core.scrap.adapter.out.persistence.entity.ScrapLogJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrapLogRepository extends JpaRepository<ScrapLogJpaEntity, Long> {
}
