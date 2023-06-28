package sopt.org.jwtSeminar.exception.model;

import sopt.org.jwtSeminar.exception.Error;

public class ConflictException extends SoptException {
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}
