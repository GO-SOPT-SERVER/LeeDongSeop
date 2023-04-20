package sopt.org.SecondSeminar.controller.post.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UploadRequestDto {
    private String title;

    private String writing;

    private int like;

    private int dislike;
}