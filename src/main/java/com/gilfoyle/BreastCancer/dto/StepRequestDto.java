package com.gilfoyle.BreastCancer.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StepRequestDto {
    private Long stepName;
    private Date stepDate;

}
