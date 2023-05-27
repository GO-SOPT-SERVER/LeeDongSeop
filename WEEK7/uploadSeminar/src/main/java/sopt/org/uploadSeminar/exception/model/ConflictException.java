package sopt.org.uploadSeminar.exception.model;

import sopt.org.uploadSeminar.exception.Error;

public class ConflictException extends SoptException {
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}
