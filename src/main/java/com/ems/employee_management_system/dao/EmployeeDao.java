package com.ems.employee_management_system.dao;

import com.ems.employee_management_system.entity.Employee;
import com.ems.employee_management_system.repository.EmployeeRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Employee> findAll(Pageable page){
        return employeeRepo.findAll(page);
    }

    public Optional<Employee> find(Integer id){
        return employeeRepo.findById(id);
    }

    public Employee update(Employee employee){
        return employeeRepo.save(employee);
    }

    public void delete(Integer id){
        employeeRepo.deleteById(id);
    }



}
