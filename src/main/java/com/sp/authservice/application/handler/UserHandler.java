package com.sp.authservice.application.handler;

import com.sp.authservice.application.dto.UserDTO;
import com.sp.authservice.application.mapper.IUserMapper;
import com.sp.authservice.domain.api.IUserServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserHandler implements IUserHandler {

    private final IUserServicePort  userServicePort;
    private final IUserMapper userMapper;

    @Override
    public void createAdmin(UserDTO userDTO) {
        userServicePort.createAdmin(userMapper.toDomain(userDTO));
    }
    @Override
    public void createClient(UserDTO userDTO) {
        userServicePort.createClient(userMapper.toDomain(userDTO));
    }
}
