package sopt.org.uploadSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.uploadSeminar.controller.dto.response.EmotionCalendarResponseDto;
import sopt.org.uploadSeminar.controller.dto.response.EmotionResponseDto;
import sopt.org.uploadSeminar.domain.Emotion;
import sopt.org.uploadSeminar.exception.Error;
import sopt.org.uploadSeminar.exception.model.ConflictException;
import sopt.org.uploadSeminar.exception.model.NotFoundException;
import sopt.org.uploadSeminar.infrastructure.EmotionRepository;
import sopt.org.uploadSeminar.service.dto.request.EmotionServiceDto;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmotionService {

    private final EmotionRepository emotionRepository;

    @Transactional
    public void create(EmotionServiceDto request) {
        if (emotionRepository.existsByRecordDate(request.getRecordDate())) {
            throw new ConflictException(Error.ALREADY_EXIST_EMOTION_EXCEPTION, Error.ALREADY_EXIST_EMOTION_EXCEPTION.getMessage());
        }

        Emotion newEmotion = Emotion.newInstance(
                request.getEmotionContent(),
                request.getRecordDate(),
                request.getPositive(),
                request.getNegative(),
                request.getNeutral(),
                request.getAnalysis(),
                request.getEmotionType()
        );

        emotionRepository.save(newEmotion);
    }

    @Transactional
    public List<EmotionCalendarResponseDto> getCalendar(LocalDate date) {
        List<Emotion> emotions = emotionRepository.findByRecordDateBetween(date.withDayOfMonth(1), date.withDayOfMonth(date.lengthOfMonth()));

        return emotions.stream()
                .map(emotion -> EmotionCalendarResponseDto.of(emotion.getId(), emotion.getRecordDate(), emotion.getEmotionType()))
                .sorted(Comparator.comparing(EmotionCalendarResponseDto::getRecordDate))
                .collect(Collectors.toList());
    }

    @Transactional
    public EmotionResponseDto getOne(Long emotionId) {
        Emotion emotion = emotionRepository.findById(emotionId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_EMOTION_EXCEPTION, Error.NOT_FOUND_EMOTION_EXCEPTION.getMessage()));

        return EmotionResponseDto.of(
                emotion.getRecordDate(),
                emotion.getEmotionContent(),
                emotion.getPositive(),
                emotion.getNegative(),
                emotion.getNeutral(),
                emotion.getAnalysis(),
                emotion.getEmotionType()
        );
    }
}
