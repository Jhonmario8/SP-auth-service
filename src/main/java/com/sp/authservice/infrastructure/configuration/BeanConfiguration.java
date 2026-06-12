package com.sp.authservice.infrastructure.configuration;

import com.sp.authservice.domain.api.IPasswordServicePort;
import com.sp.authservice.domain.api.IUserServicePort;
import com.sp.authservice.domain.spi.IUserPersistencePort;
import com.sp.authservice.domain.usecase.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
public class BeanConfiguration {

    private final IUserPersistencePort userPersistencePort;
    private final IPasswordServicePort passwordServicePort;
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public IUserServicePort UserServicePort(){
        return new UserUseCase(userPersistencePort,passwordServicePort);
    }
}
