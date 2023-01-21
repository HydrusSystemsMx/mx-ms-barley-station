package com.icn.barleystation.controller;

import com.icn.barleystation.model.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = {"internal-apis", "brand"})
public interface IBrandController {

    @ApiOperation("Get all banners")
    @ApiResponses({
            @ApiResponse(code = 200, response = BannerResponse.class, message = "Ok"),
            @ApiResponse(code = 400, response = Exception.class, message = "Request error"),
            @ApiResponse(code = 401, response = Exception.class, message = "Unauthorized"),
            @ApiResponse(code = 500, response = Exception.class, message = "Internal server error")
    })
    List<BrandResponse> getAllBrands();

    @ApiOperation("Create new brand")
    @ApiResponses({
            @ApiResponse(code = 201, response = Object.class, message = "Created"),
            @ApiResponse(code = 400, response = Exception.class, message = "Request error"),
            @ApiResponse(code = 401, response = Exception.class, message = "Unauthorized"),
            @ApiResponse(code = 500, response = Exception.class, message = "Internal server error")
    })
    ResponseEntity<BrandResponse> createNewBrand(@RequestBody BrandRequest bannerRequest);

    @ApiOperation("Get a brand")
    @ApiResponses({
            @ApiResponse(code = 204, response = Object.class, message = "No Content"),
            @ApiResponse(code = 400, response = Exception.class, message = "Request error"),
            @ApiResponse(code = 401, response = Exception.class, message = "Unauthorized"),
            @ApiResponse(code = 500, response = Exception.class, message = "Internal server error")
    })
    ResponseEntity<BrandResponse> getBrandyId(@PathVariable("id") Integer id);

}
