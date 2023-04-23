package sopt.org.week3Advanced.controller.dto.response.post;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseDto {

    private Long postId;
    private String title;

    public static PostResponseDto of(Long postId, String title) {
        return new PostResponseDto(postId, title);
    }
}