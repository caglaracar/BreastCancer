package com.gilfoyle.BreastCancer.service;

import com.gilfoyle.BreastCancer.Security.JwtTokenUtil;
import com.gilfoyle.BreastCancer.Security.LoginRequest;
import com.gilfoyle.BreastCancer.dto.LoginResponse;
import com.gilfoyle.BreastCancer.dto.UserRequestDto;
import com.gilfoyle.BreastCancer.entity.User;
import com.gilfoyle.BreastCancer.model.UserContext;
import com.gilfoyle.BreastCancer.repository.UserRepository;
import com.gilfoyle.BreastCancer.util.SecurityUtil;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));
    }


    public User saveUser(User user) {
        user.getSecurityUser().setPassword(user.getSecurityUser().getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User updateUser(Long userId, UserRequestDto userDto) throws Exception {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found with id: " + userId));

        // Kullanıcı bilgilerini güncelle
        existingUser.setName(userDto.getName());
        existingUser.setSurname(userDto.getSurname());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setAge(userDto.getAge());
        existingUser.setWeight(userDto.getWeight());
        existingUser.setHeight(userDto.getHeight());
        existingUser.setgeneralAnalysisRegion(userDto.getgeneralAnalysisRegion());

        // Güncellenmiş kullanıcıyı kaydet
        return userRepository.save(existingUser);
    }

    public LoginResponse login(LoginRequest loginRequest){
        User user = userRepository.findBySecurityUser_Username(loginRequest.getUsername())
                .orElseThrow(
                        () -> new RuntimeException("Böyle bir kullanıcı yok")
                );
        var encodedPassword="{noop}" +loginRequest.getPassword();
        if(encodedPassword.equals(user.getSecurityUser().getPassword())){
            LoginResponse loginResponse = generateJwtResponse(loginRequest);


            return loginResponse;
        }
        return null;
    }

    private LoginResponse generateJwtResponse(LoginRequest loginRequest) {
        User user = userRepository.findBySecurityUser_Username(loginRequest.getUsername()).get();

        String jwtToken = jwtTokenUtil.generateToken(user);

        LoginResponse loginResponse;


        loginResponse = LoginResponse.builder()
                .jwtToken(jwtToken)
                .build();

        return loginResponse;
    }

    public User getBySecurityUserId(Long securityUserId) {
        return userRepository.findBySecurityUserId(securityUserId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}


