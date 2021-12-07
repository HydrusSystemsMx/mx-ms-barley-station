package com.icn.barleystation.service;

import org.springframework.http.ResponseEntity;

import com.icn.barleystation.model.BannerRequest;
import com.icn.barleystation.model.BannerResponse;

public interface IBannerService {

	public ResponseEntity<BannerResponse> getAllBanners();

	public ResponseEntity<BannerResponse> addBanner(BannerRequest banner);
	
	public ResponseEntity<BannerResponse> getAllActiveBanners();

	public ResponseEntity<BannerResponse> changeStatusBanner(Boolean status, Integer idBanner);

}
