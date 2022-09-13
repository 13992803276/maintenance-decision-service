package com.cn.maintenancedecisionservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lexu
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "traffic")
public class Traffic {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "root_no")
    private String rootNo;
    private String year;
    private Long xxhc;
    private Long zxhc;
    private Long dxhc;
    private Long tdhc;
    private Long jzxc;
    private Long zxkc;
    private Long dkc;

}
