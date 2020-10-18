package com.andermirik.authentification.controller;

import com.andermirik.authentification.config.jwt.JwtProvider;
import com.andermirik.authentification.model.UserModel;
import com.andermirik.authentification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("/auth-service/auth")
    public String get_auth(@RequestParam("login") String login, @RequestParam("password") String password){
        UserModel user = userService.findByLoginAndPassword(login, password);
        return jwtProvider.generateToken(user.getLogin());
    }
}
