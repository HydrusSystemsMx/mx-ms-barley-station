package com.icn.barleystation.controller;

import com.icn.barleystation.mapper.adapter.BannerModelMapper;
import com.icn.barleystation.model.BannerDTO;
import com.icn.barleystation.model.BannerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icn.barleystation.model.BannerResponse;
import com.icn.barleystation.service.IBannerService;

@RestController
@RequestMapping("/api/v1/barley/banner")
public class BannerController implements IBannerController{

	@Autowired
	private BannerModelMapper bannerModelMapper;

	@Autowired
	private IBannerService bannerService;

	@GetMapping("/all")
	public ResponseEntity<BannerResponse> getAllBanners() {
		return bannerService.getAllBanners();
	}

	@GetMapping("/allActive")
	public ResponseEntity<BannerResponse> getActiveBanners() {
		return bannerService.getAllActiveBanners();
	}


	@Override
	@PostMapping("/add")
	public ResponseEntity<BannerResponse> saveContrato(@RequestBody BannerRequest bannerRequest) {
		System.out.println(bannerRequest);
		return bannerService.addBanner(bannerModelMapper.requestToBannerDto(bannerRequest));
	}
}
