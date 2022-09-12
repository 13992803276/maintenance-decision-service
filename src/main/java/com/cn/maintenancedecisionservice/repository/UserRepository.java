package com.cn.maintenancedecisionservice.repository;

import com.cn.maintenancedecisionservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lexu
 */

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByEmail(String email);
}
