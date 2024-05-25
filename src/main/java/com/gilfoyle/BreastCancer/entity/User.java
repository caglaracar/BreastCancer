package com.gilfoyle.BreastCancer.entity;


import com.gilfoyle.BreastCancer.Security.SecurityUser;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String age;
    private Long weight;
    private Long height;
    private String generalAnlysisRegion;

    @OneToMany
    private List<Exercise> exercise;

    @OneToOne
    private SecurityUser securityUser;
}
