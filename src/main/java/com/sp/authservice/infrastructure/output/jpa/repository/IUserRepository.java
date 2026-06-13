package com.sp.authservice.infrastructure.output.jpa.repository;

import com.sp.authservice.infrastructure.output.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    Boolean existsByPhoneNumber(String cellphone);

    Boolean existsByIdentificationNumber(String identificationNumber);
}
