package com.sp.authservice.application.handler;

import com.sp.authservice.application.dto.LoginRequest;
import com.sp.authservice.application.dto.LoginResponse;

public interface IAuthHandler {

    LoginResponse login(LoginRequest loginRequest);

}
