package com.sp.authservice.application.dto;


import com.sp.authservice.application.constants.ApplicationConstants;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginRequest {

    @NotBlank(message = ApplicationConstants.EMAIL_CANNOT_BE_BLANK)
    private String email;
    @NotBlank(message = ApplicationConstants.PASSWORD_CANNOT_BE_BLANK)
    private String password;

}
