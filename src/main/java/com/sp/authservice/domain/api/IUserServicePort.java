package com.sp.authservice.domain.api;

import com.sp.authservice.domain.model.User;

public interface IUserServicePort {

    void createAdmin(User user);
    void createClient(User user);

}
