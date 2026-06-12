package com.sp.authservice.infrastructure.output.jpa.repository;

import com.sp.authservice.infrastructure.output.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    Boolean findByEmail(String email);

    Boolean findByPhoneNumber(String cellphone);

    Boolean findByIdentificationNumber(String identificationNumber);
}
