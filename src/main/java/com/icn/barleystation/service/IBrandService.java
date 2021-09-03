package com.icn.barleystation.service;

import org.springframework.http.ResponseEntity;

import com.icn.barleystation.model.BrandRequest;
import com.icn.barleystation.model.BrandResponse;

public interface IBrandService {

	ResponseEntity<BrandResponse> createNewBrand(BrandRequest request);

	ResponseEntity<BrandResponse> getBrandById(Integer id);
}
