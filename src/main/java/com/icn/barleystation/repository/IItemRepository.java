package com.icn.barleystation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icn.barleystation.entity.BrandEntity;
import com.icn.barleystation.entity.ItemEntity;

@Repository
public interface IItemRepository extends JpaRepository<ItemEntity, Integer> {

	List<ItemEntity> findByBrand(BrandEntity brand);
}
