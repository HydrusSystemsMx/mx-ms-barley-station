package com.icn.barleystation.controller;

import com.icn.barleystation.model.BannerDTO;
import com.icn.barleystation.model.BannerRequest;
import com.icn.barleystation.model.BannerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = {"internal-apis", "banner"})
public interface IBannerController {

    @ApiOperation("Get all banners")
    @ApiResponses({
            @ApiResponse(code = 200, response = BannerResponse.class, message = "Ok"),
            @ApiResponse(code = 400, response = Exception.class, message = "Request error"),
            @ApiResponse(code = 401, response = Exception.class, message = "Unauthorized"),
            @ApiResponse(code = 500, response = Exception.class, message = "Internal server error")
    })
    ResponseEntity<List<BannerResponse>> getAllBanners();

    @ApiOperation("Get all active banners")
    @ApiResponses({
            @ApiResponse(code = 200, response = BannerDTO.class, message = "Ok"),
            @ApiResponse(code = 400, response = Exception.class, message = "Request error"),
            @ApiResponse(code = 401, response = Exception.class, message = "Unauthorized"),
            @ApiResponse(code = 500, response = Exception.class, message = "Internal server error")
    })
    ResponseEntity<List<BannerResponse>> getActiveBanners();

    @ApiOperation("Create new banner")
    @ApiResponses({
            @ApiResponse(code = 201, response = BannerDTO.class, message = "Created"),
            @ApiResponse(code = 400, response = Exception.class, message = "Request error"),
            @ApiResponse(code = 401, response = Exception.class, message = "Unauthorized"),
            @ApiResponse(code = 500, response = Exception.class, message = "Internal server error")
    })
    ResponseEntity<HttpStatus> saveBanner(@RequestBody BannerRequest bannerRequest);

    @ApiOperation("Update a banner")
    @ApiResponses({
            @ApiResponse(code = 204, response = BannerDTO.class, message = "No Content"),
            @ApiResponse(code = 400, response = Exception.class, message = "Request error"),
            @ApiResponse(code = 401, response = Exception.class, message = "Unauthorized"),
            @ApiResponse(code = 500, response = Exception.class, message = "Internal server error")
    })
    ResponseEntity<HttpStatus> updateBanner(@PathVariable("id") Long id, @RequestBody BannerRequest bannerRequest);

}
