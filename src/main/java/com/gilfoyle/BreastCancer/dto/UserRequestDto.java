package com.gilfoyle.BreastCancer.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String surname;
    private String password;
    private String email;
    private String generalAnlysisRegion;
    private String age;

}
