package com.cn.maintenancedecisionservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author lexu
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String email;
    @CreatedDate
    private LocalDate created;
    private String phone;
}
