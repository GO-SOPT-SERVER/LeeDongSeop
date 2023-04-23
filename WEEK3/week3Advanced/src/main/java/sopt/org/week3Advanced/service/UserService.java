package sopt.org.week3Advanced.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.week3Advanced.controller.dto.request.UserRequestDto;
import sopt.org.week3Advanced.controller.dto.response.user.UserResponseDto;
import sopt.org.week3Advanced.domain.User;
import sopt.org.week3Advanced.exception.user.userDuplicatedEmailException;
import sopt.org.week3Advanced.exception.user.userDuplicatedNicknameException;
import sopt.org.week3Advanced.infrastructure.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto create(UserRequestDto request) throws userDuplicatedNicknameException, userDuplicatedEmailException {

        validateDuplicateNickname(request.getNickname());
        validateDuplicateEmail(request.getEmail());

        User user = User.builder()
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(request.getPassword())
                .build();

        userRepository.save(user);

        return UserResponseDto.of(user.getId(), user.getNickname());
    }

    public User findOne(Long userId) {
        return userRepository.findById(userId);
    }

    private void validateDuplicateNickname(String nickname) throws userDuplicatedNicknameException {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByNickname(nickname));
        if (optionalUser.isPresent()) {
            throw new userDuplicatedNicknameException();
        }
    }

    private void validateDuplicateEmail(String email) throws userDuplicatedEmailException {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail(email));
        if (optionalUser.isPresent()) {
            throw new userDuplicatedEmailException();
        }
    }
}