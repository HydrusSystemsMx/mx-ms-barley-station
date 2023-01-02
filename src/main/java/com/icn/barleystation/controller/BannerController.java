package com.icn.barleystation.controller;

import com.icn.barleystation.commons.CommonsHelper;
import com.icn.barleystation.entity.BannerEntity;
import com.icn.barleystation.mapper.adapter.BannerModelMapper;
import com.icn.barleystation.model.BannerRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.icn.barleystation.model.BannerResponse;
import com.icn.barleystation.service.IBannerService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/barley/banner")
public class BannerController implements IBannerController{

	@Autowired
	private BannerModelMapper bannerModelMapper;

	@Autowired
	private IBannerService bannerService;

	@GetMapping("/all")
	public ResponseEntity<List<BannerResponse>> getAllBanners() {
		return ResponseEntity.ok(bannerModelMapper.bannerDtoToResponse(bannerService.getAllBanners()));
	}

	@GetMapping("/allActive")
	public ResponseEntity<List<BannerResponse>> getActiveBanners() {
		return ResponseEntity.ok(bannerModelMapper.bannerDtoToResponse(bannerService.getAllActiveBanners()));
	}

	@Override
	@PostMapping("/add")
	public ResponseEntity<HttpStatus> saveBanner(@RequestBody BannerRequest bannerRequest) {
		log.info(CommonsHelper.INICIO + "[BannerController][saveBanner]");
		bannerService.addBanner(bannerModelMapper.requestToBannerDto(bannerRequest));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<HttpStatus> updateBanner(@PathVariable("id") Integer id, @RequestBody BannerRequest bannerRequest){
		log.info(CommonsHelper.INICIO + "[BannerController][saveBanner]");
		bannerService.actualizarBanner(id, bannerModelMapper.requestToBannerDto(bannerRequest));
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
