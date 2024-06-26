package com.gilfoyle.BreastCancer.controller;

import com.gilfoyle.BreastCancer.dto.ExerciseRequestDto;
import com.gilfoyle.BreastCancer.entity.Exercise;
import com.gilfoyle.BreastCancer.entity.User;
import com.gilfoyle.BreastCancer.service.ExerciseService;
import com.gilfoyle.BreastCancer.service.UserService;
import com.gilfoyle.BreastCancer.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
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
    public ResponseEntity<?> saveExercise(@RequestBody ExerciseRequestDto exercise) {
        try {
            User user = userService.getUser(SecurityUtil.getUserId());
            Exercise savedExercise = exerciseService.saveExercise(exercise, user);
            return ResponseEntity.ok(savedExercise);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/update/{exerciseId}")
    public ResponseEntity<?> updateExercise(@RequestBody ExerciseRequestDto exercise, @PathVariable Long exerciseId) {
        System.err.println("exercise: " + exercise + " id: " + exerciseId);
        try {
            User user = userService.getUser(SecurityUtil.getUserId());
            Exercise updatedExercise = exerciseService.updateExercise(exercise, user, exerciseId);
            return ResponseEntity.ok(updatedExercise);
        } catch (UsernameNotFoundException e) {
            System.err.println("exercise: " + exercise + " id: " + exerciseId);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
