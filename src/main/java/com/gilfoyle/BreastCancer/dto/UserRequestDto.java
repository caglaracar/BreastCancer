package com.gilfoyle.BreastCancer.dto;

import lombok.Data;

//@Data
public class UserRequestDto {
    private String name;
    private String surname;
    private String password;
    private String email;
    private String generalAnlysisRegion;
    private String age;
    private Long weight;
    private Long height;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGeneralAnlysisRegion() {
        return generalAnlysisRegion;
    }

    public void setGeneralAnlysisRegion(String generalAnlysisRegion) {
        this.generalAnlysisRegion = generalAnlysisRegion;
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
}
