package sopt.org.week3Advanced.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.week3Advanced.common.dto.ApiResponseDto;
import sopt.org.week3Advanced.controller.dto.request.UserRequestDto;
import sopt.org.week3Advanced.controller.dto.response.user.UserInfoResponseDto;
import sopt.org.week3Advanced.controller.dto.response.user.UserResponseDto;
import sopt.org.week3Advanced.domain.User;
import sopt.org.week3Advanced.exception.SuccessStatus;
import sopt.org.week3Advanced.exception.user.userDuplicatedEmailException;
import sopt.org.week3Advanced.exception.user.userDuplicatedNicknameException;
import sopt.org.week3Advanced.exception.user.userNotFoundException;
import sopt.org.week3Advanced.service.UserService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) throws userDuplicatedNicknameException, userDuplicatedEmailException {
        return ApiResponseDto.success(SuccessStatus.SIGNUP_SUCCESS, userService.create(request));
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<UserInfoResponseDto> findOneUser(@PathVariable final Long userId) throws userNotFoundException {
        Optional<User> findUser = Optional.ofNullable(userService.findOne(userId));
        if (findUser.isEmpty()) {
            throw new userNotFoundException();
        }
        return ApiResponseDto.success(SuccessStatus.FIND_USER_SUCCESS, UserInfoResponseDto.of(findUser.get()));
    }

}