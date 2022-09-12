package com.cn.maintenancedecisionservice.serviceImpl;

import com.cn.maintenancedecisionservice.model.User;
import com.cn.maintenancedecisionservice.repository.UserRepository;
import com.cn.maintenancedecisionservice.result.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author lexu
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final HttpSession session;

    public Result<User> login(String password, String email) {
        User user = userRepository.findUserByEmail(email);
        if (user == null){
            return Result.failure("该邮箱未注册");
        }
        if (password.equals(user.getPassword())){
            session.setAttribute("user", user);
            return Result.success(user);
        }else{
            return Result.failure("账号密码不匹配");
        }
    }


    public Result<Void> register(User user) {
        return null;
    }

    public Result<Void> resetPass(String code, String trim) {
        return null;
    }

    public Result<Void> forgetPass(String email) {
        return null;
    }
}
