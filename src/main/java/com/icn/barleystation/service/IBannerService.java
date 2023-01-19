package com.icn.barleystation.service;

import com.icn.barleystation.model.BannerDTO;

import java.util.List;

public interface IBannerService {

	List<BannerDTO> getAllBanners();
	void addBanner(BannerDTO banner);
	void actualizarBanner(Long id, BannerDTO banner);
	List<BannerDTO> getAllActiveBanners();


}
