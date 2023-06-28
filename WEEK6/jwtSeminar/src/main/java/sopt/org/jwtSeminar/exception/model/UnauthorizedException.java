package sopt.org.jwtSeminar.exception.model;

import lombok.Getter;
import sopt.org.jwtSeminar.exception.Error;

@Getter
public class UnauthorizedException extends SoptException{
    public UnauthorizedException(Error error, String message) {
        super(error, message);
    }
}
