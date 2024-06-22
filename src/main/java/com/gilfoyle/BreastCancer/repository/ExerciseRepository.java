package com.gilfoyle.BreastCancer.repository;

import com.gilfoyle.BreastCancer.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByUserId(Long userId);
}

