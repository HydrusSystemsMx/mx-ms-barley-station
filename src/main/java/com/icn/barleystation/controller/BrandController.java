package com.icn.barleystation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/{id}")
	public ResponseEntity<BrandResponse> getBrandyId(@PathVariable("id") Integer id) {
		System.out.println("getBrandyId()");
		return brandService.getBrandById(id);
	}

	@GetMapping("/all")
	public List<BrandResponse> getAllBrands() {
		System.out.println("getAllBrands()");
		return brandService.getAllBrands();
	}
}
