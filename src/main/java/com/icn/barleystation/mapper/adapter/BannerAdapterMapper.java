package com.icn.barleystation.mapper.adapter;

import com.icn.barleystation.entity.BannerEntity;
import com.icn.barleystation.model.BannerDTO;
import com.icn.barleystation.support.JpaMapperConfig;
import com.icn.barleystation.support.PageJpaMapper;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        config = JpaMapperConfig.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true)
)
public interface BannerAdapterMapper extends PageJpaMapper<BannerDTO, BannerEntity> {
    @Override
    BannerEntity toEntity(BannerDTO contrato);

    @Override
    BannerDTO toDTO(BannerEntity entity);

}
