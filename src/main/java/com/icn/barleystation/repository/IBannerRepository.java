package com.icn.barleystation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icn.barleystation.entity.BannerEntity;

@Repository
public interface IBannerRepository extends JpaRepository<BannerEntity, Integer> {

	@Modifying
	@Query("update BannerEntity u set u.status = ?1 where u.idBanner = ?2")
	Integer cahngeBannerStatus(Boolean status, Integer idBanner);
	
	@Modifying
	@Query("select u from BannerEntity u where u.status = ?1")
	List<BannerEntity> findAllActive(Boolean status);

	
}
