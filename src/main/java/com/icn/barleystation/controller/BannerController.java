package com.icn.barleystation.controller;

import com.icn.barleystation.commons.CommonsHelper;
import com.icn.barleystation.handler.BannerHandler;
import com.icn.barleystation.model.BannerRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.icn.barleystation.model.BannerResponse;

import java.util.List;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/barley/banner")
public class BannerController implements IBannerController{
	private final BannerHandler bannerHandler;
	@GetMapping("/all")
	public ResponseEntity<List<BannerResponse>> getAllBanners() {
		log.info(CommonsHelper.INICIO + "[getAllBanners]");
		return ResponseEntity.ok(bannerHandler.getAllBanners());
	}

	@GetMapping("/allActive")
	public ResponseEntity<List<BannerResponse>> getActiveBanners() {
		log.info(CommonsHelper.INICIO + "[getActiveBanners]");
		return ResponseEntity.ok(bannerHandler.getAllActiveBanners());
	}

	@PostMapping("/add")
	public ResponseEntity<HttpStatus> saveBanner(@RequestBody BannerRequest bannerRequest) {
		log.info(CommonsHelper.INICIO + "[saveBanner]");
		bannerHandler.addBanner(bannerRequest);
		log.info(CommonsHelper.FIN + "[saveBanner]");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<HttpStatus> updateBanner(@PathVariable("id") Long bannerId, @RequestBody BannerRequest bannerRequest){
		log.info(CommonsHelper.INICIO + "[updateBanner]");
		bannerHandler.updateBanner(bannerId, bannerRequest);
		log.info(CommonsHelper.FIN + "[updateBanner]");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
