package com.icn.barleystation.mapper.adapter;

import com.icn.barleystation.entity.BannerEntity;
import com.icn.barleystation.entity.BrandEntity;
import com.icn.barleystation.model.*;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface BrandModelMapper {
    @Mapping(source = "brandName", target = "brandName")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "status", target = "status")
    BrandDTO requestToBrandDto(BrandRequest brandRequest);
    BrandResponse brandDtoToResponse(BrandDTO brandsDTOS);
    List<BrandResponse> bannerDtoToResponse(List<BrandDTO> bannerDTOS);
    BrandResponse brandEntityToResponse(BrandEntity brandEntity);
}
