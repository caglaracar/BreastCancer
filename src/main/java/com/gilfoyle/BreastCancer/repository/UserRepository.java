package com.gilfoyle.BreastCancer.repository;

import com.gilfoyle.BreastCancer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
