package sopt.org.SecondSeminar.controller.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.SecondSeminar.controller.post.dto.request.UploadRequestDto;
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
        System.out.println(postList.get(postId.intValue() - 1).toString());

        return postId + "번 게시물이 등록되었습니다!";
    }

    @GetMapping("/post/{postId}")
    public String getOnePost(@PathVariable final Long postId) {
        System.out.println("요청 게시물 아이디: " + postId);

        // 서비스 계층에서 게시물 아이디로 게시물을 찾는 메서드 호출

        return "게시물 조회 성공";
    }

    @GetMapping("/post/search")
    public String searchPost(@RequestParam final String title) {
        System.out.println("게시물 제목 검색 인자: " + title);

        // 서비스 계층에서 게시물 닉네임으로 게시물을 찾는 메서드 호출

        return "게시물 검색 성공";
    }

}
