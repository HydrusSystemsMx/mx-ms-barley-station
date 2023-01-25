package com.icn.barleystation.mapper.adapter;

import com.icn.barleystation.entity.ItemEntity;
import com.icn.barleystation.model.ItemDTO;
import com.icn.barleystation.support.JpaMapperConfig;
import com.icn.barleystation.support.PageJpaMapper;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        config = JpaMapperConfig.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        uses = {BrandAdapterMapper.class}
)
public interface ItemAdapterMapper extends PageJpaMapper<ItemDTO, ItemEntity> {
    @Override
    ItemEntity toEntity(ItemDTO banner);

    @Override
    ItemDTO toDTO(ItemEntity entity);

    @Override
    List<ItemDTO> toDTOS(List<ItemEntity> entities);
}
