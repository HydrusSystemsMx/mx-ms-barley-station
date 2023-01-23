package com.icn.barleystation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icn.barleystation.entity.BrandEntity;

public interface IBrandJpaRepository extends JpaRepository<BrandEntity, Long> {
    BrandEntity findByBrandName(String brandName);
}
