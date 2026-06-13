package com.sp.authservice.domain.exception;

import com.sp.authservice.domain.constants.DomainConstants;

public class InvalidCredentialsException extends DomainException{
    public InvalidCredentialsException() {
        super(DomainConstants.MSG_INVALID_CREDENTIALS);
    }
}
