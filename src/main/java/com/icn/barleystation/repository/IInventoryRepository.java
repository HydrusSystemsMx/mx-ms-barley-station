package com.icn.barleystation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icn.barleystation.entity.InventoryEntity;

@Repository
public interface IInventoryRepository extends JpaRepository<InventoryEntity, Integer> {

	@Modifying
	@Query("select u from InventoryEntity u where u.itemTag = ?1")
	List<InventoryEntity> findByIdItem(String itemTag);

	@Modifying
	@Query("update InventoryEntity u set u.stack = ?1, u.updateDate =?2 where u.itemTag = ?3")
	Integer updateStack(Integer stack, Date updateDate, String itemTag);
	
	

}
