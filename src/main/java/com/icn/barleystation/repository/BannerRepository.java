package com.icn.barleystation.repository;

import com.icn.barleystation.model.BannerDTO;


public interface BannerRepository {
    void addBanner(BannerDTO banner);
    void updateBanner(Long bannerId, BannerDTO banner);
}
