package com.gilfoyle.BreastCancer.controller;

import com.gilfoyle.BreastCancer.dto.ExerciseRequestDto;
import com.gilfoyle.BreastCancer.entity.Exercise;
import com.gilfoyle.BreastCancer.service.ExerciseService;
import com.gilfoyle.BreastCancer.service.UserService;
import com.gilfoyle.BreastCancer.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController{

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<Exercise> getExercises() {
        return exerciseService.getUserExercise();
    }

    @PostMapping("/save")
    public Exercise saveExercise(@RequestBody ExerciseRequestDto exercise) {
        return exerciseService.saveExercise(exercise, userService.getUser(SecurityUtil.getUserId()));
    }
}
