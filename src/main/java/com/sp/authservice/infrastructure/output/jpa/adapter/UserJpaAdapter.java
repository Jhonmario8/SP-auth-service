package com.sp.authservice.infrastructure.output.jpa.adapter;

import com.sp.authservice.domain.model.User;
import com.sp.authservice.domain.spi.IUserPersistencePort;
import com.sp.authservice.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.sp.authservice.infrastructure.output.jpa.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort  {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;


    @Override
    public void saveUser(User user) {
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public Boolean findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Boolean findByPhoneNumber(String cellphone) {
        return userRepository.findByPhoneNumber(cellphone);
    }

    @Override
    public Boolean findByIdentificationNumber(String identificationNumber) {
        return userRepository.findByIdentificationNumber(identificationNumber);
    }
}
