package com.gilfoyle.BreastCancer.service;

import com.gilfoyle.BreastCancer.Security.SecurityUser;
import com.gilfoyle.BreastCancer.dto.ExerciseRequestDto;
import com.gilfoyle.BreastCancer.entity.Exercise;
import com.gilfoyle.BreastCancer.entity.User;
import com.gilfoyle.BreastCancer.mapper.ExerciseMapper;
import com.gilfoyle.BreastCancer.repository.ExerciseRepository;
import com.gilfoyle.BreastCancer.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final UserService userService;

    public Exercise getExercise(Long id) {
        return exerciseRepository.findById(id).orElse(null);
    }

    public List<Exercise> getUserExercise() {
        return userService.getUser(SecurityUtil.getUserId()).getExercise();
    }

    public Exercise saveExercise(ExerciseRequestDto exercise, User user) {
        Exercise newExercise = ExerciseMapper.mapToExercise(exercise);
        newExercise.setUser(user);

        return exerciseRepository.save(newExercise);
    }

    public void saveExercise(Exercise exercise) {
        exerciseRepository.save((exercise));
    }

    public Exercise updateExercise(ExerciseRequestDto exercise, User user, Long id) {
        Exercise fExercise = exerciseRepository.findById(id).orElse(null);
        if (fExercise == null) {
            return null;
        }

        fExercise.setExerciseName(exercise.getExerciseName());
        fExercise.setExerciseDate(exercise.getExerciseDate());
        fExercise.setDoneExercise(exercise.isDoneExercise());
        fExercise.setCalories(exercise.getCalories());
        fExercise.setDifficultyLevel(exercise.getDifficultyLevel());
        fExercise.setUser(user);

        return exerciseRepository.save(fExercise);
    }
}
