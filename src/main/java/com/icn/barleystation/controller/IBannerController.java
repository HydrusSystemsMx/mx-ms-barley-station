package com.icn.barleystation.controller;

import com.icn.barleystation.model.BannerDTO;
import com.icn.barleystation.model.BannerRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = {"apis-internas", "banner"})
public interface IBannerController {

    @ApiOperation("Create new banner")
    @ApiResponses({
            @ApiResponse(code = 200, response = BannerDTO.class, message = "Ok"),
            @ApiResponse(code = 400, response = Exception.class, message = "Request error"),
            @ApiResponse(code = 401, response = Exception.class, message = "Unauthorized"),
            @ApiResponse(code = 500, response = Exception.class, message = "Internal server error")
    })
    ResponseEntity<HttpStatus> saveBanner(@RequestBody BannerRequest bannerRequest);

}
