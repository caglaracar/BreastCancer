package com.gilfoyle.BreastCancer.controller;

import com.gilfoyle.BreastCancer.Security.UserDetailService;
import com.gilfoyle.BreastCancer.entity.User;
import com.gilfoyle.BreastCancer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin

public class GeneralController {
    @Autowired
    private  UserService userService;
    @Autowired
    private UserDetailService userDetailService;
    public User getUser() {
        var user= (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var securityUser=userDetailService.findByUsername(user.getUsername());
        return userService.getBySecurityUserId(securityUser.getId());
    }

}
