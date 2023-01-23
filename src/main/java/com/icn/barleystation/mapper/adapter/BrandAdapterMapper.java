package com.icn.barleystation.mapper.adapter;

import com.icn.barleystation.entity.BannerEntity;
import com.icn.barleystation.entity.BrandEntity;
import com.icn.barleystation.model.*;
import com.icn.barleystation.support.JpaMapperConfig;
import com.icn.barleystation.support.PageJpaMapper;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring",
        config = JpaMapperConfig.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true)
)
public interface BrandAdapterMapper extends PageJpaMapper<BrandDTO, BrandEntity> {
    @Override
    BrandEntity toEntity(BrandDTO banner);

    @Override
    BrandDTO toDTO(BrandEntity entity);

    @Override
    List<BrandDTO> toDTOS(List<BrandEntity> entities);
}
