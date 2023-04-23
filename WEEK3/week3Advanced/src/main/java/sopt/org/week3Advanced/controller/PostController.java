package sopt.org.week3Advanced.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.week3Advanced.common.dto.ApiResponseDto;
import sopt.org.week3Advanced.controller.dto.request.PostRequestDto;
import sopt.org.week3Advanced.controller.dto.response.post.PostInfoResponseDto;
import sopt.org.week3Advanced.controller.dto.response.post.PostResponseDto;
import sopt.org.week3Advanced.domain.Post;
import sopt.org.week3Advanced.domain.User;
import sopt.org.week3Advanced.exception.SuccessStatus;
import sopt.org.week3Advanced.exception.post.postNotFoundException;
import sopt.org.week3Advanced.exception.post.uploadPostUserNotExistException;
import sopt.org.week3Advanced.service.PostService;
import sopt.org.week3Advanced.service.UserService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final UserService userService;
    private final PostService postService;

    @PostMapping("/post/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<PostResponseDto> upload(@RequestBody @Valid final PostRequestDto request) throws uploadPostUserNotExistException {
        Optional<User> optionalUser = Optional.ofNullable(userService.findOne(request.getUserId()));
        if (optionalUser.isEmpty()){
            throw new uploadPostUserNotExistException();
        }
        return ApiResponseDto.success(SuccessStatus.UPLOAD_SUCCESS, postService.upload(request, optionalUser.get()));
    }

    @GetMapping("/post/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<PostInfoResponseDto> getOnePost(@PathVariable final Long postId) throws postNotFoundException {
        Optional<Post> findPost = Optional.ofNullable(postService.findOne(postId));
        if (findPost.isEmpty()) {
            throw new postNotFoundException();
        }
        return ApiResponseDto.success(SuccessStatus.FIND_POST_SUCCESS, PostInfoResponseDto.of(findPost.get()));
    }
}