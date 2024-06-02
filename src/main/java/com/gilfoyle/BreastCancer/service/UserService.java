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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;
    public User getUser(Long id) {
        UserContext context
                = SecurityUtil.getUserContext().orElseGet(() -> null);

        return userRepository.findById(id).orElse(null);
    }


    public User saveUser(User user) {
        user.getSecurityUser().setPassword(user.getSecurityUser().getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User updateUser(UserRequestDto user, User fUser) {
        fUser.setAge(user.getAge());
        fUser.setEmail(user.getEmail());
        fUser.setName(user.getName());
        fUser.setSurname(user.getSurname());
        fUser.setWeight(user.getWeight());
        fUser.setHeight(user.getHeight());
        fUser.setGeneralAnlysisRegion(user.getGeneralAnlysisRegion());

        return userRepository.save(fUser);
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

}
