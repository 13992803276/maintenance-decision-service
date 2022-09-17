package com.cn.maintenancedecisionservice.service;

import com.cn.maintenancedecisionservice.model.ExportTrafficGroup;
import com.cn.maintenancedecisionservice.model.Traffic;
import com.cn.maintenancedecisionservice.repository.ExportTrafficGroupRepository;
import com.cn.maintenancedecisionservice.repository.TrafficRepository;
import com.cn.maintenancedecisionservice.result.Result;
import com.cn.maintenancedecisionservice.utils.ExcelUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lexu
 */
@Service
@Slf4j
public class TrafficService {

    @Autowired
    TrafficRepository trafficRepository;

    @Autowired
    ExportTrafficGroupRepository exportTrafficGroupRepository;

//    public TrafficService(TrafficRepository trafficRepository, ExportTrafficGroupRepository exportTrafficGroupRepository) {
//        this.trafficRepository = trafficRepository;
//        this.exportTrafficGroupRepository = exportTrafficGroupRepository;
//    }

    public Result<String> importTraffic(String filename, String rootNo) {
        List<Object[]> trafficObjectsList = ExcelUtil.importExcel(filename);
        List<Traffic> trafficList = new ArrayList<>();
        for (Object[] objects : trafficObjectsList) {
            if (objects.length > 0) {
                Traffic traffic = Traffic.builder().rootNo(rootNo)
                        .year(objects[0].toString())
                        .xxhc(Long.parseLong(objects[1].toString()))
                        .zxhc(Long.parseLong(objects[2].toString()))
                        .dxhc(Long.parseLong(objects[3].toString()))
                        .tdhc(Long.parseLong(objects[4].toString()))
                        .jzxc(Long.parseLong(objects[5].toString()))
                        .zxkc(Long.parseLong(objects[6].toString()))
                        .dkc(Long.parseLong(objects[7].toString()))
                        .build();
                trafficList.add(traffic);
            }
        }
        if (trafficList.size() > 0) {
            trafficRepository.saveAll(trafficList);
            return Result.success("success");
        } else {
            return Result.failure("导入失败");
        }
    }

    public String exportTrafficReport(String rootNo) {
        List<ExportTrafficGroup> exportTrafficGroup = exportTrafficGroupRepository.getExportTrafficGroup(rootNo);
        log.info("exportTrafficGroup is {} ", exportTrafficGroup);
        return "success";
    }

}
