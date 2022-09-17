package com.cn.maintenancedecisionservice.repository;

import com.cn.maintenancedecisionservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lexu
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByEmail(String email);
}
