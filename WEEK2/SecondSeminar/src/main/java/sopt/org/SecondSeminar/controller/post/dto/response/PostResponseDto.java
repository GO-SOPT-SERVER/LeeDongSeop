package sopt.org.SecondSeminar.controller.post.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostResponseDto {

    private Long id;

    private String title;

    private String writing;

    private int like;

    private int dislike;
}