package com.icn.barleystation.mapper.adapter;


import com.icn.barleystation.model.BannerDTO;
import com.icn.barleystation.model.BannerRequest;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface BannerModelMapper {

    @Mapping(source = "url", target = "url")
    @Mapping(source = "status", target = "status")
    BannerDTO requestToBannerDto(BannerRequest bannerRequest);

}
