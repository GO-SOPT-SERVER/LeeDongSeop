package sopt.org.uploadSeminar.exception.model;

import lombok.Getter;
import sopt.org.uploadSeminar.exception.Error;

@Getter
public class UnauthorizedException extends SoptException{
    public UnauthorizedException(Error error, String message) {
        super(error, message);
    }
}
