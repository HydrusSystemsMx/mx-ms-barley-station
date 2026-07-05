package com.icn.barleystation.mapper.adapter;

import com.icn.barleystation.entity.UserEntity;
import com.icn.barleystation.model.*;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface UserModelMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "profileImage", target = "profileImage")
    @Mapping(source = "mail", target = "mail")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "createdDate", target = "createdDate")
    UserDTO requestToUserDto(UserRequest userRequest);
    UserResponse userDtoToResponse(UserDTO userDTOS);
    List<UserResponse> userDtoToResponse(List<UserDTO> userDTOS);
    UserResponse userEntityToResponse(UserEntity userEntity);
}
