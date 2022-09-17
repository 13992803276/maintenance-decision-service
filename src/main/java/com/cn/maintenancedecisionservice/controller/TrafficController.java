package com.cn.maintenancedecisionservice.controller;

import com.cn.maintenancedecisionservice.result.Result;
import com.cn.maintenancedecisionservice.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author lexu
 */
@RestController
@RequestMapping("/traffic")
public class TrafficController {

    @Autowired
    TrafficService trafficService;

    @PostMapping("/import")
    public Result<String> importTraffic(String fileName, String rootNo){
        fileName = "/Users/lexu/Desktop/test.xlsx";
        return trafficService.importTraffic(fileName, rootNo);
    }

    @PostMapping("/export")
    public String exportTraffic(String rootNo){
        return trafficService.exportTrafficReport(rootNo);
    }
}
