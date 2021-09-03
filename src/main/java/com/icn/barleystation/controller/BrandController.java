package com.icn.barleystation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icn.barleystation.model.BrandRequest;
import com.icn.barleystation.model.BrandResponse;
import com.icn.barleystation.service.IBrandService;

@RestController
@RequestMapping("/api/v1/barley/brand")
public class BrandController {

	@Autowired
	IBrandService brandService;

	@PostMapping("/create")
	public ResponseEntity<BrandResponse> createNewBrand(@RequestBody BrandRequest request) {
		System.out.println("createNewBrand()");
		return brandService.createNewBrand(request);
	}
}
