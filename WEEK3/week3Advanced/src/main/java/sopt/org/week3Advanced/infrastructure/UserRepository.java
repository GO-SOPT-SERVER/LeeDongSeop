package sopt.org.week3Advanced.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.week3Advanced.domain.User;

public interface UserRepository extends Repository<User, Long> {
    void save(User user);

    User findById(Long userId);

    User findByNickname(String nickname);

    User findByEmail(String email);
}