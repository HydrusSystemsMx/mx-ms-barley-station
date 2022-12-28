package com.icn.barleystation.controller;

import com.icn.barleystation.model.BannerDTO;
import com.icn.barleystation.model.BannerRequest;
import com.icn.barleystation.model.BannerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = {"apis-internas", "contrato", "persona", "empresa"})
public interface IBannerController {

    @ApiOperation("Crear un nuevo contrato asociado a una persona y una empresa")
    @ApiResponses({
            @ApiResponse(code = 200, response = BannerDTO.class, message = "Información del contrato"),
            @ApiResponse(code = 400, response = Exception.class, message = "Error por validaciones."),
            @ApiResponse(code = 401, response = Exception.class, message = "La petición necesita autorización."),
            @ApiResponse(code = 500, response = Exception.class, message = "Internal server error")
    })
    ResponseEntity<BannerResponse> saveContrato(@RequestBody BannerRequest bannerRequest);

}
