package sopt.org.week3Advanced.controller.dto.response.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import sopt.org.week3Advanced.domain.User;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInPostDto {

    private Long userId;

    private String nickname;
    private String email;
    private String password;

    public static UserInPostDto of(User user) {

        return new UserInPostDto(user.getId(), user.getNickname(), user.getEmail(), user.getPassword());
    }
}