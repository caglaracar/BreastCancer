package com.gilfoyle.BreastCancer.dto;

import lombok.Data;

import java.util.Date;

@Data

public class ExerciseRequestDto {
    private String ExerciseName;
    private Date ExerciseDate;
    private boolean isDoneExercise;
}
