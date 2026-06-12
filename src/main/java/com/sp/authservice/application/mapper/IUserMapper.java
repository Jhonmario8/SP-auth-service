package com.sp.authservice.application.mapper;


import com.sp.authservice.application.dto.UserDTO;
import com.sp.authservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUserMapper {

    User toDomain(UserDTO userDTO);

    UserDTO toDTO(User user);

}
