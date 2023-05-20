package sopt.org.jwtSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.jwtSeminar.domain.Board;

public interface BoardRepository extends Repository<Board, Long> {

    // CREATE
    void save(Board board);

    // READ


    // UPDATE

    // DELETE
}
