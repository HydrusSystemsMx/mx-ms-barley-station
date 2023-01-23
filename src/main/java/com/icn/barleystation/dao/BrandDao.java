package com.icn.barleystation.dao;

import com.icn.barleystation.model.BrandResponse;

import java.util.List;

public interface BrandDao {
    BrandResponse getBrandById(Long id);
    List<BrandResponse> getAllBrands();
    boolean getBrandByBrandName(String brandName);
}
