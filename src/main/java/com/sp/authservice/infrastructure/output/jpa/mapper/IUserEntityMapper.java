package com.sp.authservice.infrastructure.output.jpa.mapper;

import com.sp.authservice.domain.model.User;
import com.sp.authservice.infrastructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUserEntityMapper {

    User toDomain(UserEntity userEntity);

    UserEntity toEntity(User user);

}
