package com.cn.maintenancedecisionservice.controller;


import com.cn.maintenancedecisionservice.model.User;
import com.cn.maintenancedecisionservice.result.Result;
import com.cn.maintenancedecisionservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * @author lexu
 */
@RestController
@RequestMapping("/common")
public class UserController {

    @Autowired
    HttpSession session;

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result<User> login(String password, String email) {
        return userService.login(password, email);
    }


    @PostMapping("/register")
    public Result<Void> register(User user) {
        return userService.register(user);
    }


    @PostMapping("/reset")
    public Result<Void> reset(@RequestParam("code") String code, @RequestParam("pass") String pass) {
        return userService.resetPass(code, pass.trim());
    }

    @PostMapping("/forget")
    public Result<Void> forget(@RequestParam("email") String email) {
        return userService.forgetPass(email);
    }

    @GetMapping("/logout")
    public Result<Void> logout() {
        session.removeAttribute("usesr");
        return Result.success();
    }


}
