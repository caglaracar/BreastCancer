package com.gilfoyle.BreastCancer.controller;

import com.gilfoyle.BreastCancer.Security.UserDetailService;
import com.gilfoyle.BreastCancer.dto.SaveUserRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
@CrossOrigin

public class SecurityUserController {
    private final UserDetailService securityUserService;
    @PostMapping("/saveuser")
    public ResponseEntity <Void> saveUser(@RequestBody SaveUserRequestDto saveUserRequestDto) {
        securityUserService.saveUser(saveUserRequestDto);
        return ResponseEntity.ok().build();
    }
}
