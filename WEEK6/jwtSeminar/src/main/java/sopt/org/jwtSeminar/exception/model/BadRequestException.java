package sopt.org.jwtSeminar.exception.model;

import sopt.org.jwtSeminar.exception.Error;

public class BadRequestException extends SoptException {
    public BadRequestException(Error error, String message) {
        super(error, message);
    }
}
