package com.icn.barleystation.mapper.adapter;


import com.icn.barleystation.entity.BannerEntity;
import com.icn.barleystation.model.BannerDTO;
import com.icn.barleystation.model.BannerRequest;
import com.icn.barleystation.model.BannerResponse;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface BannerModelMapper {

    @Mapping(source = "url", target = "url")
    @Mapping(source = "status", target = "status")
    BannerDTO requestToBannerDto(BannerRequest bannerRequest);
    BannerResponse bannerDtoToResponse(BannerDTO bannerDTOS);
    List<BannerResponse> bannerDtoToResponse(List<BannerDTO> bannerDTOS);
    BannerResponse bannerEntityToResponse(BannerEntity bannerEntity);
}
