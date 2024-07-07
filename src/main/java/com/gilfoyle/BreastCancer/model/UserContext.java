package com.gilfoyle.BreastCancer.model;

import com.gilfoyle.BreastCancer.Security.SecurityUser;
import com.gilfoyle.BreastCancer.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserContext {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String age;
    private Long weight;
    private Long height;
    private String generalAnalysisRegion;
    private SecurityUser securityUser;

    // Constructor that takes a User object and initializes UserContext fields
    public UserContext(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.age = user.getAge();
        this.weight = user.getWeight();
        this.height = user.getHeight();
        this.generalAnalysisRegion = user.getgeneralAnalysisRegion();
        this.securityUser = user.getSecurityUser();
    }

    // Getters and Setters (if needed)


    public SecurityUser getSecurityUser() {
        return securityUser;
    }

    public void setSecurityUser(SecurityUser securityUser) {
        this.securityUser = securityUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public String getGeneralAnalysisRegion() {
        return generalAnalysisRegion;
    }

    public void setGeneralAnalysisRegion(String generalAnalysisRegion) {
        this.generalAnalysisRegion = generalAnalysisRegion;
    }
}

