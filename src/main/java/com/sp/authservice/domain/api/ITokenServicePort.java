package com.sp.authservice.domain.api;

import com.sp.authservice.domain.model.User;

import java.util.Map;


public interface ITokenServicePort {

    String generateToken(User user);
    Map<String, Object> validateToken(String token);

}
