package com.icn.barleystation.mapper.adapter;

import com.icn.barleystation.entity.BrandEntity;
import com.icn.barleystation.entity.ItemEntity;
import com.icn.barleystation.model.*;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface ItemModelMapper {
    @Mapping(source = "nameItem", target = "nameItem")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "status", target = "status")
    ItemDTO requestToItemDto(RequestItem requestItem);
    ItemResponse itemDtoToResponse(ItemDTO itemDTO);
    List<ItemResponse> itemDtoToResponse(List<ItemDTO> itemDTOS);
    ItemResponse itemEntityToResponse(ItemEntity itemEntity);
}
