package com.icn.barleystation.controller;

import java.util.List;

import com.icn.barleystation.commons.CommonsHelper;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RestController
@RequestMapping("/api/v1/barley/brand")
public class BrandController implements IBrandController{

	@Autowired
	IBrandService brandService;

	@PostMapping("/create")
	public ResponseEntity<BrandResponse> createNewBrand(@RequestBody BrandRequest request) {
		log.info(CommonsHelper.INICIO + "[createNewBrand]");
		return brandService.createNewBrand(request);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BrandResponse> getBrandyId(@PathVariable("id") Integer id) {
		log.info(CommonsHelper.INICIO + "[getBrandyId]");
		return brandService.getBrandById(id);
	}

	@GetMapping("/all")
	public List<BrandResponse> getAllBrands() {
		log.info(CommonsHelper.INICIO + "[getAllBrands]");
		return brandService.getAllBrands();
	}
}
