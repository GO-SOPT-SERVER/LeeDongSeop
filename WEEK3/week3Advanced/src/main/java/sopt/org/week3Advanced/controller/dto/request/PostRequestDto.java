package sopt.org.week3Advanced.controller.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostRequestDto {

    @NotBlank
    private String title;

    @NotEmpty
    private String writing;

    @NotNull
    private Long userId;
}