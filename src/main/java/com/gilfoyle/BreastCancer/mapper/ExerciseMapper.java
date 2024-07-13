package com.gilfoyle.BreastCancer.mapper;

import com.gilfoyle.BreastCancer.dto.ExerciseRequestDto;
import com.gilfoyle.BreastCancer.entity.Exercise;


public class ExerciseMapper {
    public static Exercise mapToExercise(ExerciseRequestDto exerciseRequestDto) {
        Exercise exercise = new Exercise();
        exercise.setExerciseName(exerciseRequestDto.getExerciseName());
        exercise.setExerciseDate(exerciseRequestDto.getExerciseDate());
        exercise.setDoneExercise(exerciseRequestDto.isDoneExercise());
        exercise.setCalories(exerciseRequestDto.getCalories());
        exercise.setDifficultyLevel(exerciseRequestDto.getDifficultyLevel());
        exercise.setTestResult(exerciseRequestDto.getTestResult());
        return exercise;
    }

}
