package com.gilfoyle.BreastCancer.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GetStepRequestDto {
    private Date startDate;
    private Date endDate;
}
