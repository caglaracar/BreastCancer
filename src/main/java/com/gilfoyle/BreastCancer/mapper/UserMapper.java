package com.gilfoyle.BreastCancer.mapper;

import com.gilfoyle.BreastCancer.dto.UserRequestDto;
import com.gilfoyle.BreastCancer.entity.User;



public class UserMapper {
    public static User mapToUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setSurname(userRequestDto.getSurname());
        user.setPassword(userRequestDto.getPassword());
        user.setEmail(userRequestDto.getEmail());
        user.setGeneralAnlysisRegion(userRequestDto.getGeneralAnlysisRegion());
        return user;
    }

}
