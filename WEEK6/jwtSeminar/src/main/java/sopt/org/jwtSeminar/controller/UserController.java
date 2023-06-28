package sopt.org.jwtSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.jwtSeminar.common.dto.ApiResponse;
import sopt.org.jwtSeminar.config.jwt.TokenDto;
import sopt.org.jwtSeminar.controller.dto.request.UserLoginRequestDto;
import sopt.org.jwtSeminar.controller.dto.request.UserSignupRequestDto;
import sopt.org.jwtSeminar.controller.dto.response.UserLoginResponseDto;
import sopt.org.jwtSeminar.exception.Success;
import sopt.org.jwtSeminar.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Boolean> create(@RequestBody @Valid final UserSignupRequestDto request) throws Exception {
        return ApiResponse.success(Success.SIGNUP_SUCCESS, userService.signup(request));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserLoginResponseDto> login(@RequestBody @Valid final UserLoginRequestDto request) throws Exception {
        return ApiResponse.success(Success.LOGIN_SUCCESS, userService.login(request));
    }

    @GetMapping("/user/get")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserLoginResponseDto> getUser(@RequestParam final String email) throws Exception {
        return ApiResponse.success(Success.USER_GET_SUCCESS, userService.getUser(email));
    }

    @GetMapping("/refresh")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<TokenDto> refresh(@RequestBody TokenDto token) throws Exception {
        return ApiResponse.success(Success.REFRESH_SUCCESS, userService.refreshAccessToken(token));
    }
}
