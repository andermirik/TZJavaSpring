package com.andermirik.userpanel.repository;

import com.andermirik.userpanel.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByLogin(String login);
    List<UserModel> findByRoleName(String name);
}
