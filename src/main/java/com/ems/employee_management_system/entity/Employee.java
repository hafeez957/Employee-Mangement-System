package com.ems.employee_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empid;
    private String name;
    private String email;
    private double salary;
    private String department;
    private String address;
    @CreationTimestamp
    private LocalDateTime creation;
    @UpdateTimestamp
    private LocalDateTime updation;

}
