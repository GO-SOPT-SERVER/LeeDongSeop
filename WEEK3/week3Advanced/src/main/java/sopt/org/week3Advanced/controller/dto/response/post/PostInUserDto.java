package sopt.org.week3Advanced.controller.dto.response.post;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import sopt.org.week3Advanced.domain.Post;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostInUserDto { //User 객체 안에 Post 객체를 넣을 때 of 메서드 무한 호출을 방지하기 위해 User에 대한 부분은 빠진 dto

    private Long postId;

    private String title;
    private String writing;

    public static PostInUserDto of(Post post) {

        return new PostInUserDto(post.getId(), post.getTitle(), post.getWriting());
    }
}