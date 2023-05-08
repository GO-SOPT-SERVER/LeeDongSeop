package sopt.org.week3Advanced.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.week3Advanced.controller.dto.request.PostRequestDto;
import sopt.org.week3Advanced.controller.dto.response.post.PostResponseDto;
import sopt.org.week3Advanced.domain.Post;
import sopt.org.week3Advanced.domain.User;
import sopt.org.week3Advanced.infrastructure.PostRepository;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public PostResponseDto upload(PostRequestDto request, User user) {

        Post post = Post.builder()
                .title(request.getTitle())
                .writing(request.getWriting())
                .user(user)
                .build();

        postRepository.save(post);

        //User의 postList에도 생성된 Post를 추가
        user.addPost(post);

        return PostResponseDto.of(post.getId(), post.getTitle());
    }

    public Post findOne(Long postId) {
        return postRepository.findById(postId);
    }
}