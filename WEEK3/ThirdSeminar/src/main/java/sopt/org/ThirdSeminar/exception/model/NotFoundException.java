package sopt.org.ThirdSeminar.exception.model;

import sopt.org.ThirdSeminar.exception.Error;

public class NotFoundException extends SoptException {
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}