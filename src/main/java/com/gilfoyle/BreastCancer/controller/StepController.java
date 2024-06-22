package com.gilfoyle.BreastCancer.controller;

import com.gilfoyle.BreastCancer.dto.GetStepRequestDto;
import com.gilfoyle.BreastCancer.dto.StepRequestDto;
import com.gilfoyle.BreastCancer.entity.Step;
import com.gilfoyle.BreastCancer.service.StepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/step")
@CrossOrigin
public class StepController  {
    private final StepService stepService;

    @PostMapping("/get")
    public List<Step> getStep(@RequestBody GetStepRequestDto getStepRequestDto) {
        return stepService.getStep(getStepRequestDto);
    }

    @PostMapping("/save/{exerciseId}")
    public Step saveStep(@RequestBody StepRequestDto step, @PathVariable Long exerciseId) {
        return stepService.saveStep(step, exerciseId);
    }
}
