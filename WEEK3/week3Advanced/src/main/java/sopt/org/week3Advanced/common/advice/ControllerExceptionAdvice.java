package sopt.org.week3Advanced.common.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sopt.org.week3Advanced.common.dto.ApiResponseDto;
import sopt.org.week3Advanced.exception.ErrorStatus;
import sopt.org.week3Advanced.exception.post.postNotFoundException;
import sopt.org.week3Advanced.exception.post.uploadPostUserNotExistException;
import sopt.org.week3Advanced.exception.user.userDuplicatedEmailException;
import sopt.org.week3Advanced.exception.user.userDuplicatedNicknameException;
import sopt.org.week3Advanced.exception.user.userNotFoundException;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    /*
     * 400 BAD_REQUEST
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponseDto handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return ApiResponseDto.error(ErrorStatus.VALIDATION_REQUEST_MISSING_EXCEPTION);
    }

    /*
     * 409 CONFLICT
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(userDuplicatedNicknameException.class)
    protected ApiResponseDto handleUserDuplicatedNicknameException(final userDuplicatedNicknameException e) {
        return ApiResponseDto.error(ErrorStatus.CONFLICT_NICKNAME_EXCEPTION);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(userDuplicatedEmailException.class)
    protected ApiResponseDto handleUserDuplicatedEmailException(final userDuplicatedEmailException e) {
        return ApiResponseDto.error(ErrorStatus.CONFLICT_EMAIL_EXCEPTION);
    }

    /*
    * 404 NOT_FOUND
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(userNotFoundException.class)
    protected ApiResponseDto handleUserNotExistException(final userNotFoundException e) {
        return ApiResponseDto.error(ErrorStatus.USER_NOT_EXIST_EXCEPTION);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(postNotFoundException.class)
    protected ApiResponseDto handlePostNotExistException(final postNotFoundException e) {
        return ApiResponseDto.error(ErrorStatus.POST_NOT_EXIST_EXCEPTION);
    }

    /*
     * 422 UNPROCESSABLE_CONTENT
     */
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(uploadPostUserNotExistException.class)
    protected ApiResponseDto handleUploadPostUserNotExistException(final uploadPostUserNotExistException e) {
        return ApiResponseDto.error(ErrorStatus.UPLOAD_POST_USER_NOT_EXIST_EXCEPTION);
    }
}