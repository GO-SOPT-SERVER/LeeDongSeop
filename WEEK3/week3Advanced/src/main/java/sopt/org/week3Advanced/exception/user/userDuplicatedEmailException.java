package sopt.org.week3Advanced.exception.user;

public class userDuplicatedEmailException extends Throwable {

    public userDuplicatedEmailException() {
        super();
    }

    public userDuplicatedEmailException(String message) {
        super(message);
    }
}
