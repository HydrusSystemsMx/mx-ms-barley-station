package com.icn.barleystation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.icn.barleystation.entity.BannerEntity;

public interface IBannerJpaRepository extends JpaRepository<BannerEntity, Long> {
	
	@Modifying
	@Query("select u from BannerEntity u where u.status = ?1 ORDER BY id DESC")
	List<BannerEntity> findAllActiveOrderByIdDesc(Boolean status);

	List<BannerEntity> findAllByOrderByIdDesc();
	BannerEntity findByUrl(String bannerUrl);

	Optional<BannerEntity> findById(Long bannerId);
}
