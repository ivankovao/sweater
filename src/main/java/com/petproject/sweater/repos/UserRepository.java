package com.petproject.sweater.repos;

import com.petproject.sweater.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

    User findByActivationCode(String code);
}
