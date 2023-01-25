package com.icn.barleystation.dao;

import com.icn.barleystation.model.BrandDTO;
import com.icn.barleystation.model.BrandResponse;

import java.util.List;

public interface BrandDao {
    BrandDTO getBrandById(Long id);
    List<BrandResponse> getAllBrands();
    boolean getBrandByBrandName(String brandName);
}
