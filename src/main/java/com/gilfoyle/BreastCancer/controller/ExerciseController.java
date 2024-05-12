package com.gilfoyle.BreastCancer.controller;

import com.gilfoyle.BreastCancer.dto.ExerciseRequestDto;
import com.gilfoyle.BreastCancer.entity.Exercise;
import com.gilfoyle.BreastCancer.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/exercise")
public class ExerciseController {
   private final ExerciseService exerciseService;

   @GetMapping("/get/{id}")
   public Exercise getExercise(@PathVariable Long id) {
      return exerciseService.getExercise(id);
   }

    @DeleteMapping("/delete/{id}")
    public void deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
    }

    @PutMapping("/update/{id}")
    public Exercise updateExercise(@RequestBody ExerciseRequestDto exercise, @PathVariable Long id) {
        return exerciseService.updateExercise(exercise, id);
    }

    @PostMapping("/save")
    public Exercise saveExercise(@RequestBody ExerciseRequestDto exercise) {
        return exerciseService.saveExercise(exercise);
    }
}
