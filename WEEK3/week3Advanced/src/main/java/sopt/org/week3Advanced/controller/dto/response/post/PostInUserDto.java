package sopt.org.week3Advanced.controller.dto.response.post;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import sopt.org.week3Advanced.domain.Post;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostInUserDto {

    private Long postId;

    private String title;
    private String writing;

    public static PostInUserDto of(Post post) {

        return new PostInUserDto(post.getId(), post.getTitle(), post.getWriting());
    }
}