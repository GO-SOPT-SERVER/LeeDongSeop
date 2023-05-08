package sopt.org.week3Advanced.controller.dto.response.post;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import sopt.org.week3Advanced.controller.dto.response.user.UserInPostDto;
import sopt.org.week3Advanced.domain.Post;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostInfoResponseDto { //찾은 Post 객체의 정보를 return하기 위한 dto

    private Long postId;

    private String title;
    private String writing;

    private UserInPostDto user; //UserInfoResponseDto 사용하면 PostInfoResponseDto와 함께 of 메소드가 무한히 호출되므로 별도의 Dto를 만듬

    public static PostInfoResponseDto of(Post post) {

        return new PostInfoResponseDto(post.getId(), post.getTitle(), post.getWriting(), UserInPostDto.of(post.getUser()));
    }
}