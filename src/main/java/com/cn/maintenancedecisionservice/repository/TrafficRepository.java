package com.cn.maintenancedecisionservice.repository;

import com.cn.maintenancedecisionservice.model.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author lexu
 */
public interface TrafficRepository extends JpaRepository<Traffic, Integer> {

    //List<Traffic> findallByYear(String year);

    //List<Traffic> findAllByRootNo(String rootNo);
}
