package com.sp.authservice.infrastructure.input.controller;

import com.sp.authservice.application.dto.LoginRequest;
import com.sp.authservice.application.dto.LoginResponse;
import com.sp.authservice.application.handler.IAuthHandler;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final IAuthHandler authHandler;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authHandler.login(loginRequest);
    }
    
}
