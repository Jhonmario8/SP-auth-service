package com.sp.authservice.domain.spi;

import com.sp.authservice.domain.model.User;

public interface IUserPersistencePort {

    void saveUser(User user);
    Boolean findByEmail(String email);
    Boolean findByPhoneNumber(String cellphone);
    Boolean findByIdentificationNumber(String identificationNumber);
}
