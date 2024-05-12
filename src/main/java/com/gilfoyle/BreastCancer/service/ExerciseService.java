package com.gilfoyle.BreastCancer.service;

import com.gilfoyle.BreastCancer.dto.ExerciseRequestDto;
import com.gilfoyle.BreastCancer.entity.Exercise;
import com.gilfoyle.BreastCancer.mapper.ExerciseMapper;
import com.gilfoyle.BreastCancer.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public Exercise getExercise(Long id) {
        return exerciseRepository.findById(id).orElse(null);
    }

    public Exercise saveExercise(ExerciseRequestDto exercise) {
        return exerciseRepository.save(ExerciseMapper.mapToExercise(exercise));
    }

    public void deleteExercise(Long id) {
        exerciseRepository.deleteById(id);
    }

    public Exercise updateExercise(ExerciseRequestDto exercise, Long id) {
        Exercise fExercise= exerciseRepository.findById(id).orElseThrow(() -> new RuntimeException("Exercise not found"));
        fExercise.setExerciseName(exercise.getExerciseName());
        fExercise.setExerciseName(exercise.getExerciseName());
        fExercise.setExerciseDate(exercise.getExerciseDate());
        fExercise.setDoneExercise(exercise.isDoneExercise());

        return exerciseRepository.save(fExercise);
    }


    public void saveExercise(Exercise exercise) {
         exerciseRepository.save((exercise));
    }
}
