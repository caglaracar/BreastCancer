package com.gilfoyle.BreastCancer.repository;

import com.gilfoyle.BreastCancer.entity.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

public interface StepRepository extends JpaRepository<Step, Long> {

    @Query("SELECT e FROM Step e WHERE e.date BETWEEN :startDate AND :endDate")
    List<Step> findAllByDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
