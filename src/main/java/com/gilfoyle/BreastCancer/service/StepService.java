package com.gilfoyle.BreastCancer.service;

import com.gilfoyle.BreastCancer.dto.GetStepRequestDto;
import com.gilfoyle.BreastCancer.dto.StepRequestDto;
import com.gilfoyle.BreastCancer.entity.Exercise;
import com.gilfoyle.BreastCancer.entity.Step;
import com.gilfoyle.BreastCancer.mapper.StepMapper;
import com.gilfoyle.BreastCancer.repository.StepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StepService {
    private final StepRepository stepRepository;
    private final ExerciseService exerciseService;

    public List<Step> getStep(GetStepRequestDto getStepRequestDto) {
        return stepRepository.findAllByDateBetween(getStepRequestDto.getStartDate(), getStepRequestDto.getEndDate());
    }

    public Step saveStep(StepRequestDto stepDto, Long exerciseId) {
        // İlk önce Step nesnesini oluştur.
        Step step = StepMapper.mapToStep(stepDto);

        // Step nesnesini önce veritabanına kaydet.
        step = stepRepository.save(step);

        // Exercise nesnesini al.
        Exercise exercise = exerciseService.getExercise(exerciseId);

        // Step nesnesini Exercise nesnesine ekle.
        exercise.getStep().add(step);

        // Exercise nesnesini güncelle.
        exerciseService.saveExercise(exercise);

        // Güncellenmiş Step nesnesini döndür.
        return step;
    }

}
