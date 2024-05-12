package com.gilfoyle.BreastCancer.repository;

import com.gilfoyle.BreastCancer.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
