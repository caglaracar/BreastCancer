package com.gilfoyle.BreastCancer.Security;

import com.gilfoyle.BreastCancer.dto.SaveUserRequestDto;
import com.gilfoyle.BreastCancer.entity.User;
import com.gilfoyle.BreastCancer.repository.UsersRepository;
import com.gilfoyle.BreastCancer.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UsersRepository securityUserRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUser user = securityUserRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(SecurityUser user) {
        return user.getRoles().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveUser(SaveUserRequestDto saveUserRequestDto) {
        SecurityUser securityUser = new SecurityUser();
        securityUser.setUsername(saveUserRequestDto.username());
        securityUser.setPassword( passwordEncoder.encode(saveUserRequestDto.password()));

        User user = createUser(saveUserRequestDto);

        user.setSecurityUser(securityUser);
        userService.saveUser(user);
        securityUserRepository.save(securityUser);
    }

    private User createUser(SaveUserRequestDto saveUserRequestDto) {
        User user = new User();
        user.setName(saveUserRequestDto.name());
        user.setSurname(saveUserRequestDto.surname());
        user.setEmail(saveUserRequestDto.email());
        user.setAge(saveUserRequestDto.age());
        user.setWeight(saveUserRequestDto.weight());
        user.setHeight(saveUserRequestDto.height());
        user.setGeneralAnlysisRegion(saveUserRequestDto.generalAnlysisRegion());
        return user;
    }

}


