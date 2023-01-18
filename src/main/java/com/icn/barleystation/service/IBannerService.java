package com.icn.barleystation.service;

import com.icn.barleystation.model.BannerDTO;

import java.util.List;

public interface IBannerService {

	public List<BannerDTO> getAllBanners();
	public void addBanner(BannerDTO banner);
	public void actualizarBanner(Long id, BannerDTO banner);
	public List<BannerDTO> getAllActiveBanners();


}
