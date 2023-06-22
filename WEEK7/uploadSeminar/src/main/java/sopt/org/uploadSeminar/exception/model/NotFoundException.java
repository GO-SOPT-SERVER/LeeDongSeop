package sopt.org.uploadSeminar.exception.model;

import sopt.org.uploadSeminar.exception.Error;

public class NotFoundException extends SoptException {
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}
