package com.sp.authservice.domain.api;

import com.sp.authservice.domain.model.Auth;

public interface IAuthServicePort {
    Auth login(Auth auth);

}
