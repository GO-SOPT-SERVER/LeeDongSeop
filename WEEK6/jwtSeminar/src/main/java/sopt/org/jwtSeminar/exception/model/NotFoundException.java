package sopt.org.jwtSeminar.exception.model;

import sopt.org.jwtSeminar.exception.Error;

public class NotFoundException extends SoptException {
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}
