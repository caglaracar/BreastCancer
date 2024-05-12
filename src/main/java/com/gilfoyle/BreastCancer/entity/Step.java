package com.gilfoyle.BreastCancer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Data
public class Step {


    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user_id;
    private Date date;
    private Long steps;

}
