package com.gilfoyle.BreastCancer.repository;

import com.gilfoyle.BreastCancer.Security.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<SecurityUser, Long> {
    SecurityUser findByUsername(String username);
}
