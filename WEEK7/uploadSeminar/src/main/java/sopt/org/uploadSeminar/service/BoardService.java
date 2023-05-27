package sopt.org.uploadSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.uploadSeminar.controller.dto.request.BoardImageListRequestDto;
import sopt.org.uploadSeminar.domain.Board;
import sopt.org.uploadSeminar.domain.Image;
import sopt.org.uploadSeminar.domain.User;
import sopt.org.uploadSeminar.exception.Error;
import sopt.org.uploadSeminar.exception.model.NotFoundException;
import sopt.org.uploadSeminar.infrastructure.BoardRepository;
import sopt.org.uploadSeminar.infrastructure.ImageRepository;
import sopt.org.uploadSeminar.infrastructure.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final ImageRepository imageRepository;

    @Transactional
    public void create(Long userId, List<String> boardImageUrlList, BoardImageListRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        // 게시글 생성
        Board newBoard = Board.newInstance(
                user,
                request.getTitle(),
                request.getContent(),
                request.getIsPublic()
        );

        boardRepository.save(newBoard);

        // 이미지 생성
        for (String boardImageUrl: boardImageUrlList) {
            imageRepository.save(Image.newInstance(newBoard, boardImageUrl));
        }
    }
}
