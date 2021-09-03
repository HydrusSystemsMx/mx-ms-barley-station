package com.icn.barleystation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icn.barleystation.entity.BrandEntity;

@Repository
public interface IBrandRepository extends JpaRepository<BrandEntity, Integer> {

}
