package com.gilfoyle.BreastCancer.repository;

import com.gilfoyle.BreastCancer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findBySecurityUserId(Long securityUserId);
    Optional<User> findBySecurityUser_Username(String username);
}
