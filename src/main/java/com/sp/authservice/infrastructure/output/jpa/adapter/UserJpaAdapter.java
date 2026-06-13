package com.sp.authservice.infrastructure.output.jpa.adapter;

import com.sp.authservice.domain.exception.NotFoundException;
import com.sp.authservice.domain.model.User;
import com.sp.authservice.domain.spi.IUserPersistencePort;
import com.sp.authservice.infrastructure.output.jpa.entity.RoleEntity;
import com.sp.authservice.infrastructure.output.jpa.entity.UserEntity;
import com.sp.authservice.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.sp.authservice.infrastructure.output.jpa.repository.IRoleRepository;
import com.sp.authservice.infrastructure.output.jpa.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort  {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final IRoleRepository roleRepository;

    @Override
    public void saveUser(User user) {

        RoleEntity role = roleRepository.findByName(user.getRole())
                .orElseThrow(() -> new NotFoundException("Role not found: " + user.getRole().name()));
        UserEntity userEntity = userEntityMapper.toEntity(user);
        userEntity.setRoleEntity(role);
        userRepository.save(userEntity);

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email).map(userEntityMapper::toDomain);
    }

    @Override
    public Boolean findByPhoneNumber(String cellphone) {
        return userRepository.existsByPhoneNumber(cellphone);
    }

    @Override
    public Boolean findByIdentificationNumber(String identificationNumber) {
        return userRepository.existsByIdentificationNumber(identificationNumber);
    }
}
