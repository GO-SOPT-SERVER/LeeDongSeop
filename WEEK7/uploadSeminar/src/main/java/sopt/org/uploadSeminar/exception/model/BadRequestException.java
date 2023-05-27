package sopt.org.uploadSeminar.exception.model;

import sopt.org.uploadSeminar.exception.Error;

public class BadRequestException extends SoptException {
    public BadRequestException(Error error, String message) {
        super(error, message);
    }
}
