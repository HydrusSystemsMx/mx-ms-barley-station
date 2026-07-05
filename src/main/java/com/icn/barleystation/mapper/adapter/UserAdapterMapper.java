package com.icn.barleystation.mapper.adapter;

import com.icn.barleystation.entity.UserEntity;
import com.icn.barleystation.model.UserDTO;
import com.icn.barleystation.support.JpaMapperConfig;
import com.icn.barleystation.support.PageJpaMapper;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        config = JpaMapperConfig.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface UserAdapterMapper extends PageJpaMapper<UserDTO, UserEntity> {
    @Override
    UserEntity toEntity(UserDTO userDTO);

    @Override
    UserDTO toDTO(UserEntity entity);

    @Override
    List<UserDTO> toDTOS(List<UserEntity> entities);
}
