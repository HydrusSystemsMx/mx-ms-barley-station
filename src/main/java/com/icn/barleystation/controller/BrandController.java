package com.icn.barleystation.controller;

import java.util.List;

import com.icn.barleystation.commons.CommonsHelper;
import com.icn.barleystation.handler.BrandHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.icn.barleystation.model.BrandRequest;
import com.icn.barleystation.model.BrandResponse;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/barley/brand")
public class BrandController implements IBrandController{
	private final BrandHandler brandHandler;

	@PostMapping("/create")
	public void createNewBrand(@RequestBody BrandRequest request) {
		log.info(CommonsHelper.START + "[createNewBrand]");
		brandHandler.createNewBrand(request);
		log.info(CommonsHelper.END + "[createNewBrand]");
	}

	@GetMapping("/{id}")
	public ResponseEntity<BrandResponse> getBrandyId(@PathVariable("id") Long id) {
		log.info(CommonsHelper.START + "[getBrandyId]");
		return new ResponseEntity<>(brandHandler.getBrandById(id), HttpStatus.OK);
	}

	@GetMapping("/all")
	public List<BrandResponse> getAllBrands() {
		log.info(CommonsHelper.START + "[getAllBrands]");
		return new ResponseEntity<>(brandHandler.getAllBrands(), HttpStatus.OK).getBody();
	}
}
