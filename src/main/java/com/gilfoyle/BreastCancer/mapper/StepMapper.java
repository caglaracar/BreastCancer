package com.gilfoyle.BreastCancer.mapper;

import com.gilfoyle.BreastCancer.dto.StepRequestDto;
import com.gilfoyle.BreastCancer.entity.Step;

public class StepMapper {
    public static Step mapToStep(StepRequestDto stepRequestDto) {
        Step step = new Step();
        step.setSteps(stepRequestDto.getStepName());
        step.setDate(stepRequestDto.getStepDate());
        return step;
    }
}
