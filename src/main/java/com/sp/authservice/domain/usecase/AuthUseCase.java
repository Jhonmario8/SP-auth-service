package com.sp.authservice.domain.usecase;

import com.sp.authservice.domain.api.IAuthServicePort;
import com.sp.authservice.domain.api.IPasswordServicePort;
import com.sp.authservice.domain.api.ITokenServicePort;
import com.sp.authservice.domain.exception.InvalidCredentialsException;
import com.sp.authservice.domain.model.Auth;
import com.sp.authservice.domain.model.User;
import com.sp.authservice.domain.spi.IUserPersistencePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthUseCase implements IAuthServicePort {

    private final IUserPersistencePort userPersistencePort;
    private final IPasswordServicePort passwordServicePort;
    private final ITokenServicePort tokenServicePort;

    @Override
    public Auth login(Auth auth) {

        User user = userPersistencePort.findByEmail(auth.getEmail())
                .orElseThrow(InvalidCredentialsException::new);

        if (passwordServicePort.matches(auth.getPassword(), user.getPassword())) {
            auth.setToken(tokenServicePort.generateToken(user));
            auth.setPassword(null);
            auth.setEmail(null);
            return auth;
        } else {
            throw new InvalidCredentialsException();
        }

    }
}
