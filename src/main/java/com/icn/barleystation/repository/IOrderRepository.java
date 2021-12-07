package com.icn.barleystation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icn.barleystation.entity.OrderEntity;

@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity, Integer> {

	List<OrderEntity> findAllByIdRequest(String idRequest);

	@Modifying
	@Query("select u from OrderEntity u where u.idUser = ?1 and u.status = ?2")
	List<OrderEntity> findByIdUser(Integer idUser, Integer status);

	@Modifying
	@Query("update OrderEntity u set u.status = ?2 where u.idRequest = ?1")
	Integer rollBackStatus(String idRequest, Integer status);
	
	@Modifying
	@Query("select u from OrderEntity u where u.status = ?1")
	List<OrderEntity> findByOrderAtend(Integer status);

}
