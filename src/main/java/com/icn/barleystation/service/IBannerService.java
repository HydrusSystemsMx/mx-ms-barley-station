package com.icn.barleystation.service;

import com.icn.barleystation.entity.BannerEntity;
import com.icn.barleystation.model.BannerDTO;
import org.springframework.http.ResponseEntity;

import com.icn.barleystation.model.BannerResponse;

import java.util.List;

public interface IBannerService {

	public List<BannerDTO> getAllBanners();

	public void addBanner(BannerDTO banner);
	public void actualizarBanner(Integer id, BannerDTO banner);
	
	public List<BannerDTO> getAllActiveBanners();

	public ResponseEntity<BannerResponse> changeStatusBanner(Boolean status, Integer idBanner);

}
