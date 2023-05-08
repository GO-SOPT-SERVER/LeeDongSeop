package sopt.org.week3Advanced.exception.user;

public class userNotFoundException extends Throwable {
    public userNotFoundException() {
        super();
    }

    public userNotFoundException(String message) {
        super(message);
    }
}
