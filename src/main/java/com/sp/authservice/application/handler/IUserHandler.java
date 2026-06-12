package com.sp.authservice.application.handler;

import com.sp.authservice.application.dto.UserDTO;

public interface IUserHandler {
    void createAdmin(UserDTO userDTO);
    void createClient(UserDTO userDTO);
}
