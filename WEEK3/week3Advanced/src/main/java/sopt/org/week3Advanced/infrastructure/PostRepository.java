package sopt.org.week3Advanced.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.week3Advanced.domain.Post;

public interface PostRepository extends Repository<Post, Long>{
    void save(Post post);

    Post findById(Long postId);
}