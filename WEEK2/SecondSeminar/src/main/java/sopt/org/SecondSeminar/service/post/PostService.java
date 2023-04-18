package sopt.org.SecondSeminar.service.post;

import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.controller.post.dto.request.UploadRequestDto;
import sopt.org.SecondSeminar.domain.post.Post;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

@Service
public class PostService {
    public Long upload(UploadRequestDto request) {

        // 받아온 request 데이터를 토대로 실제 Post 객체 생성
        Post newPost = new Post(
                request.getTitle(),
                request.getWriting(),
                request.getLike(),
                request.getDislike()
        );

        // 데이터베이스에 저장
        postList.add(newPost);
        newPost.setId((long) postList.size());

        // 저장한 게시물 아이디 값 반환
        return newPost.getId();
    }

    public Post findOne(Long postId) {
        Post post = null;

        for (Post curPost : postList) {
            if (curPost.getId().equals(postId)) {
                post = curPost;
            }
        }

        return post;
    }

    public Post findByTitle(String postTitle) {
        Post post = null;

        for (Post curPost : postList) {
            if (curPost.getTitle().equals(postTitle)) {
                post = curPost;
            }
        }

        return post;
    }
}