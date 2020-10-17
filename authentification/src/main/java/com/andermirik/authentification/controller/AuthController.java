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

    @GetMapping("/auth")
    public String get_auth(@RequestParam("login") String login, @RequestParam("password") String password){
        UserModel user = userService.findByLoginAndPassword(login, password);
        return jwtProvider.generateToken(user.getLogin());
    }

//    @GetMapping("/register")
//    public String get_register(@RequestParam("login") String login, @RequestParam("password") String password){
//        UserModel user = new UserModel();
//        user.setPassword(password);
//        user.setLogin(login);
//        userService.saveUser(user);
//        return "OK";
//    }

//    @GetMapping("/admin/get")
//    public String getAdmin() {
//        return "Hi admin";
//    }
//
//    @GetMapping("/user/get")
//    public String getUser() {
//        return "Hi user";
//    }

}
