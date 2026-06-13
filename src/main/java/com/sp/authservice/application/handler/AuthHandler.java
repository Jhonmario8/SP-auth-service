package com.sp.authservice.application.handler;

import com.sp.authservice.application.dto.LoginRequest;
import com.sp.authservice.application.dto.LoginResponse;
import com.sp.authservice.domain.api.IAuthServicePort;
import com.sp.authservice.domain.model.Auth;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthHandler implements IAuthHandler{

    private final IAuthServicePort authServicePort;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Auth auth = new Auth();
        auth.setEmail(loginRequest.getEmail());
        auth.setPassword(loginRequest.getPassword());

        Auth authResult = authServicePort.login(auth);

        LoginResponse response = new LoginResponse();
        response.setToken(authResult.getToken());

        return response;
    }
}
