package sopt.org.SecondSeminar.controller.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.SecondSeminar.controller.post.dto.request.UploadRequestDto;
import sopt.org.SecondSeminar.controller.post.dto.response.PostResponseDto;
import sopt.org.SecondSeminar.domain.post.Post;
import sopt.org.SecondSeminar.service.post.PostService;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public String upload(@RequestBody final UploadRequestDto request) {

        // 서비스 계층에 게시물을 등록하는 메서드를 호출
        Long postId = postService.upload(request);
        System.out.println(postService.findOne(postId).toString());

        return postId + "번 게시물이 등록되었습니다!";
    }

    @GetMapping("/post/{postId}")
    public PostResponseDto getOnePost(@PathVariable final Long postId) {

        // 서비스 계층에서 게시물 아이디로 게시물을 찾는 메서드 호출
        Post findPost = postService.findOne(postId);

        return new PostResponseDto(findPost.getId(), findPost.getTitle(), findPost.getWriting(), findPost.getLike(), findPost.getDislike());
    }

    @GetMapping("/post/search")
    public PostResponseDto searchPost(@RequestParam final String title) {

        // 서비스 계층에서 게시물 닉네임으로 게시물을 찾는 메서드 호출
        Post findPost = postService.findByTitle(title);

        return new PostResponseDto(findPost.getId(), findPost.getTitle(), findPost.getWriting(), findPost.getLike(), findPost.getDislike());
    }

}
