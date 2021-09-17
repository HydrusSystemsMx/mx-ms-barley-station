package com.icn.barleystation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icn.barleystation.entity.OrderEntity;

@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity, Integer> {

}
