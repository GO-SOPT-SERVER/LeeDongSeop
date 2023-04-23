package sopt.org.week3Advanced.controller.dto.response.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import sopt.org.week3Advanced.controller.dto.response.post.PostInUserDto;
import sopt.org.week3Advanced.domain.User;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInfoResponseDto {

    private Long userId;

    private String nickname;
    private String email;
    private String password;

    private List<PostInUserDto> postList; //PostInfoResponseDto 사용하면 UserInfoResponseDto와 함께 of 메소드가 무한히 호출되므로 별도의 Dto를 만듬

    public static UserInfoResponseDto of(User user) {

        List<PostInUserDto> postListDto = user.getPostList().stream().map(PostInUserDto::of).collect(Collectors.toList());
        return new UserInfoResponseDto(user.getId(), user.getNickname(), user.getEmail(), user.getPassword(), postListDto);
    }
}
