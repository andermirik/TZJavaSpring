package com.andermirik.authentification.service;

import com.andermirik.authentification.model.RoleModel;
import com.andermirik.authentification.model.UserModel;
import com.andermirik.authentification.repository.RoleRepository;
import com.andermirik.authentification.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userEntityRepository;
    @Autowired
    private RoleRepository roleEntityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserModel saveUser(UserModel user) {
        RoleModel userRole = roleEntityRepository.findByName("ROLE_USER");
        user.setRole(userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userEntityRepository.save(user);
    }

    public UserModel findByLogin(String login) {
        return userEntityRepository.findByLogin(login);
    }

    public UserModel findByLoginAndPassword(String login, String password) {
        UserModel user = findByLogin(login);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}