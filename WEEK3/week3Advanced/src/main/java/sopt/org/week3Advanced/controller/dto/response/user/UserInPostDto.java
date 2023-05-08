package sopt.org.week3Advanced.controller.dto.response.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import sopt.org.week3Advanced.domain.User;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInPostDto { //Post 객체 안에 User 객체를 넣을 때 of 메서드 무한 호출을 방지하기 위해 Post에 대한 부분은 빠진 dto

    private Long userId;

    private String nickname;
    private String email;
    private String password;

    public static UserInPostDto of(User user) {

        return new UserInPostDto(user.getId(), user.getNickname(), user.getEmail(), user.getPassword());
    }
}