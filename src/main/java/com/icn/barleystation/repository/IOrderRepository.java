package com.icn.barleystation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icn.barleystation.entity.OrderEntity;

@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity, Integer> {

	List<OrderEntity> findAllByIdRequest(Integer idRequest);

	@Modifying
	@Query("update OrderEntity u set u.status = ?2 where u.idRequest = ?1")
	Integer rollBackStatus(Integer idRequest, Integer status);

}
