package com.sp.authservice.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sp.authservice.application.constants.ApplicationConstants;
import com.sp.authservice.domain.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @NotBlank(message = ApplicationConstants.NAME_CANNOT_BE_BLANK)
    private String name;
    @NotBlank(message = ApplicationConstants.LAST_NAME_CANNOT_BE_BLANK)
    private String lastName;
    @NotBlank(message = ApplicationConstants.IDENTIFICATION_NUMBER_CANNOT_BE_BLANK)
    private String identificationNumber;
    @NotBlank(message = ApplicationConstants.PHONE_NUMBER_CANNOT_BE_BLANK)
    private String phoneNumber;
    @Email(message = ApplicationConstants.INVALID_SHOULD_BE_VALID_EMAIL)
    @NotBlank(message = ApplicationConstants.EMAIL_CANNOT_BE_BLANK)
    private String email;
    @NotBlank(message = ApplicationConstants.PASSWORD_CANNOT_BE_BLANK)
    private String password;

    private Role role;
    
}
