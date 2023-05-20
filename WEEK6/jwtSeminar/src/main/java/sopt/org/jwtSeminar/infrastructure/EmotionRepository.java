package sopt.org.jwtSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.jwtSeminar.domain.Emotion;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmotionRepository extends Repository<Emotion, Long> {

    // CREATE
    void save(Emotion emotion);

    // READ
    List<Emotion> findByRecordDateBetween(LocalDate start, LocalDate end);
    Optional<Emotion> findById(Long id);
    boolean existsByRecordDate(LocalDate recordDate);

    // UPDATE

    // DELETE
}
