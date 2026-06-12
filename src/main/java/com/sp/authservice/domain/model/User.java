package com.sp.authservice.domain.model;

import com.sp.authservice.domain.api.IPasswordServicePort;
import com.sp.authservice.domain.constants.DomainConstants;
import com.sp.authservice.domain.exception.DomainException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private static final String CELLPHONE_PATTERN = "^\\+?\\d{3,}$";
    private static final String DOCUMENT_PATTERN = "^\\d{3,}$";

    private Long id;
    private String name;
    private String lastName;
    private String identificationNumber;
    private String phoneNumber;
    private String email;
    private String password;
    private Role role;

    public void encodePassword(IPasswordServicePort passwordServicePort){
        this.password = passwordServicePort.encodePassword(this.password);
    }

    public void validate(){
        if (!this.phoneNumber.matches(CELLPHONE_PATTERN)){
            throw new DomainException(DomainConstants.INVALID_CELLPHONE_NUMBER);
        }
        if (this.identificationNumber.matches(DOCUMENT_PATTERN)){
            throw new DomainException(DomainConstants.INVALID_IDENTIFICATION_NUMBER);
        }
    }
}
