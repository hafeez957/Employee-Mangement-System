package com.ems.employee_management_system.service;

import com.ems.employee_management_system.entity.Employee;
import com.ems.employee_management_system.responseformat.ResponseStructure;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee save(Employee employee);

    Page<Employee> findAll(int page, int size);

    Optional<Employee> findById(Integer id);

    Employee update(Employee employee);

    String delete(Integer id);
}
