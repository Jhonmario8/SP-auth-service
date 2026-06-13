package com.sp.authservice.domain.spi;

import com.sp.authservice.domain.model.User;

import java.util.Optional;

public interface IUserPersistencePort {

    void saveUser(User user);
    Optional<User> findByEmail(String email);
    Boolean findByPhoneNumber(String cellphone);
    Boolean findByIdentificationNumber(String identificationNumber);
}
