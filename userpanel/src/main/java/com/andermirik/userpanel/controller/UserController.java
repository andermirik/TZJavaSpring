package com.andermirik.userpanel.controller;

import com.andermirik.userpanel.config.jwt.JwtFilter;
import com.andermirik.userpanel.config.jwt.JwtProvider;
import com.andermirik.userpanel.model.UserModel;
import com.andermirik.userpanel.service.UserService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("/user-panel-service/user/get_one")
    public String getOne(@RequestParam("username") String login) throws JSONException {
        UserModel user = userService.findByLogin(login);
        JSONObject j = new JSONObject();

        if(user!= null) {
            j.put("user_id", user.getId());
            j.put("user_name", user.getLogin());
            j.put("user_role", user.getRole().getName());

            return j.toString();
        }
        else {
            j.put("error", "user not found");
            return j.toString();
        }
    }

    @GetMapping("/user-panel-service/user/get_all")
    public String getAll() throws JSONException {
        List<UserModel> users =  userService.findAll();
        JSONObject j = new JSONObject();
        JSONArray jarr = new JSONArray();
        for(var user : users){
            JSONObject jj = new JSONObject();
            jj.put("user_id", user.getId());
            jj.put("user_name", user.getLogin());
            jj.put("user_role", user.getRole().getName());
            jarr.put(jj);
        }
        j.put("users", jarr);

        return j.toString();
    }

    @GetMapping("/user-panel-service/admin/get_all_by_role")
    public List<UserModel> getUserByRole(@RequestParam("role") String role){
        List<UserModel> users = userService.findByRoleName(role);
        return users;
    }

    @GetMapping("/user-panel-service/admin/get_by_id")
    public UserModel getUser(@RequestParam("id") Long id){
        UserModel user = userService.findById(id);
        return user;
    }

    @GetMapping("/user-panel-service/admin/register_user")
    public String getRegister(@RequestParam("login") String login, @RequestParam("password") String password){
        UserModel user = new UserModel();
        user.setPassword(password);
        user.setLogin(login);
        userService.saveUser(user);
        return "OK";
    }
}
