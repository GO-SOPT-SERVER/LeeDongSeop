package sopt.org.uploadSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.uploadSeminar.domain.Image;

public interface ImageRepository extends Repository<Image, Long> {
    // CREATE
    void save(Image image);
}
