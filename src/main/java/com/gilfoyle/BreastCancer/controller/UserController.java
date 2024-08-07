package com.gilfoyle.BreastCancer.controller;

import com.gilfoyle.BreastCancer.Security.LoginRequest;
import com.gilfoyle.BreastCancer.dto.LoginResponse;
import com.gilfoyle.BreastCancer.dto.UserRequestDto;
import com.gilfoyle.BreastCancer.entity.User;
import com.gilfoyle.BreastCancer.service.UserService;
import com.gilfoyle.BreastCancer.util.SecurityUtil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin

public class UserController extends GeneralController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/get")
    public User getUserAllDetails() {
        return userService.getUser(SecurityUtil.getUserId());
    }

    @DeleteMapping("/delete")
    public void deleteUser() {
        userService.deleteUser(getUser());
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserRequestDto userDto) {
        try {
            Long userId = SecurityUtil.getUserId();
            User updatedUser = userService.updateUser(userId, userDto); // Kullanıcıyı güncelle
            return ResponseEntity.ok(updatedUser); // Başarılı güncelleme sonucunu döndür
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error updating user: " + e.getMessage());
            // Kullanıcı bulunamadı veya başka bir hata oluştuğunda hata mesajı döndür
        }
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }





}
