package com.gilfoyle.BreastCancer.controller;

import com.gilfoyle.BreastCancer.dto.UserRequestDto;
import com.gilfoyle.BreastCancer.entity.User;
import com.gilfoyle.BreastCancer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody UserRequestDto user,@PathVariable Long id) {
        return userService.updateUser(user, id);
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody UserRequestDto user) {
        return userService.saveUser(user);
    }
}
