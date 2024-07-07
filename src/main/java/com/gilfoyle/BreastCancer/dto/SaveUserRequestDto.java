package com.gilfoyle.BreastCancer.dto;

public record SaveUserRequestDto (String username,String password, String name, String surname, String email, String generalAnalysisRegion, String age, Long weight, Long height){

}



