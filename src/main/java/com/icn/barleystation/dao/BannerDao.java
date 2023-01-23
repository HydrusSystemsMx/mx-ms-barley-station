package com.icn.barleystation.dao;

import com.icn.barleystation.model.BannerDTO;

import java.util.List;

public interface BannerDao {
    List<BannerDTO> getAllBanners();
    List<BannerDTO> getAllActiveBanners();
    boolean getBannerByUrl(String bannerUrl);
    boolean getBannerById(Long bannerId);
}
