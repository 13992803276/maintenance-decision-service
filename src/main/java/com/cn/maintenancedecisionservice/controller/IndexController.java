package com.cn.maintenancedecisionservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * @author lexu
 */
@Controller
@RequestMapping("/common")
public class IndexController {

    @Resource
    HttpServletRequest request;


    @GetMapping("/register")
    public String toRegister() {
        return "register";
    }

    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }

    @GetMapping("/index")
    public String toIndex() {
        request.setAttribute("path", "index");
        return "index";
    }

    @GetMapping("/reset")
    public String toReset() {
        return "reset";
    }

    @GetMapping("/forget")
    public String toForget() {
        return "forget";
    }

    @GetMapping("/traffic")
    public String toTraffic() {
        request.setAttribute("path", "traffic");
        return "traffic";
    }

}
