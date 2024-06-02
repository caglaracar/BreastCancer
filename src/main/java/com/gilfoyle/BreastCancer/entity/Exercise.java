package com.gilfoyle.BreastCancer.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Exercise {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonBackReference
    private User user;
    private Date exerciseDate;
    private boolean isDoneExercise;
    private Date date;
    @OneToMany
    private List<Step> step;
    private String exerciseName;
    private String calories;



}