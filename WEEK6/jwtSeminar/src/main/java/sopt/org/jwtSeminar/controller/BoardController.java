package sopt.org.jwtSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.jwtSeminar.common.dto.ApiResponse;
import sopt.org.jwtSeminar.config.resolver.UserId;
import sopt.org.jwtSeminar.controller.dto.request.BoardRequestDto;
import sopt.org.jwtSeminar.exception.Success;
import sopt.org.jwtSeminar.service.BoardService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            @UserId String email,
            @RequestBody @Valid final BoardRequestDto request) {
        boardService.create(email, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}