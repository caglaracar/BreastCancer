package com.gilfoyle.BreastCancer.Security;


import com.gilfoyle.BreastCancer.entity.User;
import com.gilfoyle.BreastCancer.repository.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Primary
@Component
//@RequiredArgsConstructor
public class BreastCancerUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> byUsername = userRepository.findBySecurityUser_Username(username);
        return byUsername
                .map(BreastCancerUserDetails::new)
                .orElseThrow(() -> new RuntimeException("user not found."));
    }

    public BreastCancerUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
