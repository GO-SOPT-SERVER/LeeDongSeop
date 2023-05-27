package sopt.org.uploadSeminar.controller.dto.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter //@ModelAttribute가 List 처리를 못함
public class BoardImageListRequestDto {

    private List<MultipartFile> boardImages;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private Boolean isPublic;
}
