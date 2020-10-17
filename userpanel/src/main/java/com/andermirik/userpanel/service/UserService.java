package com.andermirik.userpanel.service;

import com.andermirik.userpanel.model.RoleModel;
import com.andermirik.userpanel.model.UserModel;
import com.andermirik.userpanel.repository.RoleRepository;
import com.andermirik.userpanel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserModel saveUser(UserModel user) {
        RoleModel userRole = roleRepository.findByName("ROLE_USER");
        user.setRole(userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<UserModel> findAll(){ return userRepository.findAll(); }

    public UserModel findById(Long id){ return userRepository.findById(id).get(); }
    public List<UserModel> findByRoleName(String name){ return userRepository.findByRoleName(name); }

    public UserModel findByLogin(String login) {
        return userRepository.findByLogin(login);
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