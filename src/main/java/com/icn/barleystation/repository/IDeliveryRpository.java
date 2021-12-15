package com.icn.barleystation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icn.barleystation.entity.DeliveryEntity;

@Repository
public interface IDeliveryRpository extends JpaRepository<DeliveryEntity, Integer> {

	@Modifying
	@Query("select u from DeliveryEntity u where u.avaliable = ?1")
	List<DeliveryEntity> findDeliveryAvaliable(Boolean avaliable);
	
	@Modifying
	@Query("update DeliveryEntity u set u.avaliable = ?2 where u.idDelivery = ?1")
	Integer updateDeliveryStatus(Integer idDelivery, Boolean avaliable);

	DeliveryEntity findByIdDelivery(Integer idDelivery);

}
