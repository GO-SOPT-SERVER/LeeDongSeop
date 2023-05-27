package sopt.org.uploadSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.uploadSeminar.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends Repository<Post, Long> {
    List<Post> findAll();

    Optional<Post> findById(Long id);
}
