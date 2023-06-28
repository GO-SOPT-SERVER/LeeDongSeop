package sopt.org.jwtSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.jwtSeminar.controller.dto.request.BoardRequestDto;
import sopt.org.jwtSeminar.domain.Board;
import sopt.org.jwtSeminar.domain.User;
import sopt.org.jwtSeminar.exception.Error;
import sopt.org.jwtSeminar.exception.model.NotFoundException;
import sopt.org.jwtSeminar.infrastructure.BoardRepository;
import sopt.org.jwtSeminar.infrastructure.UserRepository;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void create(String email, BoardRequestDto request) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Board newBoard = Board.newInstance(
                user,
                request.getTitle(),
                request.getContent(),
                request.getIsPublic()
        );

        boardRepository.save(newBoard);
    }
}
