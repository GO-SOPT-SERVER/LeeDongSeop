package sopt.org.week3Advanced.exception.post;

public class postNotFoundException extends Throwable {
    public postNotFoundException() {
        super();
    }

    public postNotFoundException(String message) {
        super(message);
    }
}
