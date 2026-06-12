package com.sp.authservice.domain.usecase;

import com.sp.authservice.domain.api.IPasswordServicePort;
import com.sp.authservice.domain.api.IUserServicePort;
import com.sp.authservice.domain.constants.DomainConstants;
import com.sp.authservice.domain.exception.ConflictException;
import com.sp.authservice.domain.model.Role;
import com.sp.authservice.domain.model.User;
import com.sp.authservice.domain.spi.IUserPersistencePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;
    private final IPasswordServicePort passwordServicePort;


    @Override
    public void createAdmin(User user) {
        createUser(user, Role.ADMIN);
    }

    @Override
    public void createClient(User user) {
        createUser(user, Role.CLIENT);
    }

    private void createUser(User user, Role role) {
        user.setRole(role);
        user.validate();
        validateUniqueness(user);
        user.encodePassword(passwordServicePort);
        userPersistencePort.saveUser(user);
    }

    private void validateUniqueness(User user) {
        if (!userPersistencePort.findByEmail(user.getEmail())) {
            throw new ConflictException(DomainConstants.MSG_EMAIL_ALREADY_EXISTS);
        }
        if (!userPersistencePort.findByPhoneNumber(user.getPhoneNumber())) {
            throw new ConflictException(DomainConstants.MSG_PHONE_NUMBER_ALREADY_EXISTS);
        }
        if (!userPersistencePort.findByIdentificationNumber(user.getIdentificationNumber())) {
            throw new ConflictException(DomainConstants.MSG_IDENTIFICATION_NUMBER_ALREADY_EXISTS);
        }
    }
}
