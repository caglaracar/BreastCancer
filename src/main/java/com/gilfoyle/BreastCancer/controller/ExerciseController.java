package com.gilfoyle.BreastCancer.controller;

import com.gilfoyle.BreastCancer.Security.SecurityUser;
import com.gilfoyle.BreastCancer.dto.ExerciseRequestDto;
import com.gilfoyle.BreastCancer.entity.Exercise;
import com.gilfoyle.BreastCancer.service.ExerciseService;
import com.gilfoyle.BreastCancer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController extends GeneralController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("/getAll")
    public List<Exercise> getExercises() {

        return exerciseService.getUserExercise(getUser());
    }

    @PostMapping("/save")
    public Exercise saveExercise(@RequestBody ExerciseRequestDto exercise) {
        return exerciseService.saveExercise(exercise, getUser());
    }
}
