package com.andermirik.userpanel.config;

import com.andermirik.userpanel.model.UserModel;
import com.andermirik.userpanel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userService.findByLogin(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(user);
    }
}