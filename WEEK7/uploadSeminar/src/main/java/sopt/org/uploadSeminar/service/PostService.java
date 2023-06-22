package sopt.org.uploadSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.uploadSeminar.controller.dto.response.PostResponseDto;
import sopt.org.uploadSeminar.domain.Post;
import sopt.org.uploadSeminar.exception.Error;
import sopt.org.uploadSeminar.exception.model.NotFoundException;
import sopt.org.uploadSeminar.infrastructure.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public List<PostResponseDto> getList() {
        List<Post> postList = postRepository.findAll();

        return postList.stream()
                .map(post -> PostResponseDto.of(
                        post.getId(),
                        post.getImgSrc(),
                        post.getName(),
                        post.getDate(),
                        post.getContent()))
                .collect(Collectors.toList());
    }

    @Transactional
    public PostResponseDto getOne(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_POST_EXCEPTION, Error.NOT_FOUND_POST_EXCEPTION.getMessage()));

        return PostResponseDto.of(post.getId(), post.getImgSrc(), post.getName(), post.getDate(), post.getDate());
    }
}
