package com.gilfoyle.BreastCancer.controller;

import com.gilfoyle.BreastCancer.dto.UserRequestDto;
import com.gilfoyle.BreastCancer.entity.User;
import com.gilfoyle.BreastCancer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController extends GeneralController {
    private final UserService userService;

    @GetMapping("/get")
    public User getUserAllDetails() {
        return userService.getUser(getUser().getId());
    }

    @DeleteMapping("/delete")
    public void deleteUser() {
        userService.deleteUser(getUser());
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody UserRequestDto user) {
        return userService.updateUser(user,getUser());
    }

}
