package sopt.org.week3Advanced.exception.post;

public class uploadPostUserNotExistException extends Throwable {
    public uploadPostUserNotExistException() {
        super();
    }

    public uploadPostUserNotExistException(String message) {
        super(message);
    }
}
