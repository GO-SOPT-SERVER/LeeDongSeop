package sopt.org.week3Advanced.controller.dto.response.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseDto { //User가 생성되었을 때 간단한 정보만 return하는 dto

    private Long userId;
    private String nickname;

    public static UserResponseDto of(Long userId, String nickname) {
        return new UserResponseDto(userId, nickname);
    }
}