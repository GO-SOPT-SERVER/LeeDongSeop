package sopt.org.week3Advanced.controller.dto.response.post;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseDto { //Post가 생성되었을 때 간단한 정보만 return하는 dto

    private Long postId;
    private String title;

    public static PostResponseDto of(Long postId, String title) {
        return new PostResponseDto(postId, title);
    }
}