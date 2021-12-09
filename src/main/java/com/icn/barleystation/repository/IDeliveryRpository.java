package com.icn.barleystation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icn.barleystation.entity.DeliveryEntity;

@Repository
public interface IDeliveryRpository extends JpaRepository<DeliveryEntity, Integer> {

}
