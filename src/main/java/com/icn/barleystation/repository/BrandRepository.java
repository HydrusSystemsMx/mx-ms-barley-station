package com.icn.barleystation.repository;

import com.icn.barleystation.model.BrandDTO;
import com.icn.barleystation.model.BrandResponse;

public interface BrandRepository {
    BrandResponse createNewBrand(BrandDTO brandDTO);
}
