package com.gilfoyle.BreastCancer.mapper;

import com.gilfoyle.BreastCancer.dto.ExerciseRequestDto;
import com.gilfoyle.BreastCancer.entity.Exercise;


public class ExerciseMapper {
    public static Exercise mapToExercise(ExerciseRequestDto exerciseRequestDto) {
        Exercise exercise = new Exercise();
        exercise.setExerciseName(exerciseRequestDto.getExerciseName());
        exercise.setExerciseDate(exerciseRequestDto.getExerciseDate());
        exercise.setDoneExercise(exerciseRequestDto.isDoneExercise());
        return exercise;
    }

//    public static ExerciseResponseDto mapToExerciseResponseDto(Exercise exercise) {
//        ExerciseResponseDto exerciseResponseDto = new ExerciseResponseDto();
//        exerciseResponseDto.setExerciseName(exercise.getExerciseName());
//        exerciseResponseDto.setExerciseDate(exercise.getExerciseDate());
//        exerciseResponseDto.setDone(exercise.isDone());
//        return exerciseResponseDto;
//    }

}
