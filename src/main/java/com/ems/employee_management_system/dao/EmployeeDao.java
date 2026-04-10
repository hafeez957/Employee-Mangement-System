package com.ems.employee_management_system.dao;

import com.ems.employee_management_system.entity.Employee;
import com.ems.employee_management_system.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EmployeeDao {

    private final EmployeeRepo employeeRepo;

    public Employee save(Employee employee){
        return employeeRepo.save(employee);
    }

    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }

}
