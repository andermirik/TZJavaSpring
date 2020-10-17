package com.andermirik.authentification.repository;

import com.andermirik.authentification.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByLogin(String login);
}
