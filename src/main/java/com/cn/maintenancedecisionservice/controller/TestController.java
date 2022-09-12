package com.cn.maintenancedecisionservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoll
 */
@RestController
@RequestMapping(value ="/hello")
public class TestController {
    @GetMapping(value ="/test")
    public String test(){
        return "login";
    }
}



