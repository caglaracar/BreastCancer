package com.gilfoyle.BreastCancer.service;

import com.gilfoyle.BreastCancer.dto.UserRequestDto;
import com.gilfoyle.BreastCancer.entity.User;
import com.gilfoyle.BreastCancer.mapper.UserMapper;
import com.gilfoyle.BreastCancer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(UserRequestDto user) {
        return userRepository.save(UserMapper.mapToUser(user));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(UserRequestDto user, Long id) {
        User fUser= userRepository.findById(id).orElseThrow(() -> new RuntimeException("Exercise not found"));
        fUser.setAge(user.getAge());
        fUser.setEmail(user.getEmail());
        fUser.setName(user.getName());
        fUser.setSurname(user.getSurname());
        fUser.setGeneralAnlysisRegion(user.getGeneralAnlysisRegion());

        return userRepository.save(fUser);
    }

    public User getBySecurityUserId(Long securityUserId) {
        return userRepository.findBySecurityUserId(securityUserId);
    }

}
