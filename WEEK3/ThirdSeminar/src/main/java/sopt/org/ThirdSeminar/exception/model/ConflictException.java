package sopt.org.ThirdSeminar.exception.model;

import sopt.org.ThirdSeminar.exception.Error;

public class ConflictException extends SoptException {
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}