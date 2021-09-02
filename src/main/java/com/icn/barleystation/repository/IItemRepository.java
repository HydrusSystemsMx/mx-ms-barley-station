package com.icn.barleystation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icn.barleystation.entity.ItemEntity;

@Repository
public interface IItemRepository extends JpaRepository<ItemEntity, Integer> {

}
