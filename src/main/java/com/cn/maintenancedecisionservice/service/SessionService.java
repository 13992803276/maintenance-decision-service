package com.cn.maintenancedecisionservice.service;

import com.cn.maintenancedecisionservice.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


/**
 * @author lexu
 */
@Service
public class SessionService {
    @Resource
    private HttpSession session;

    public User getCurUser(){
        return (User) session.getAttribute("user");
    }

    public Integer getCurUserId(){
        return getCurUser().getId();
    }

    public void set(String key, String val){
        session.setAttribute(key, val);
    }

    public Object get(String key){
        return session.getAttribute(key);
    }

}
