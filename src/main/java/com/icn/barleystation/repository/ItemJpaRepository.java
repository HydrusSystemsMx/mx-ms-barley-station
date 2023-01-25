package com.icn.barleystation.repository;

import com.icn.barleystation.entity.BrandEntity;
import com.icn.barleystation.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemJpaRepository extends JpaRepository<ItemEntity, Long> {
    List<ItemEntity> findByBrand(BrandEntity brand);

    Object findByNameItem(String nameItem);
}
