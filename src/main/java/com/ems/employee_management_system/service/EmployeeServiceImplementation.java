package com.ems.employee_management_system.service;

import com.ems.employee_management_system.dao.EmployeeDao;
import com.ems.employee_management_system.entity.Employee;
import com.ems.employee_management_system.exceptions.NameNullException;
import com.ems.employee_management_system.responseformat.ResponseStructure;
import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService{

    private final EmployeeDao employeeDao;


    @Override
    public Employee save(Employee employee) {

        return employeeDao.save(employee);

    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        Optional<Employee> emp=employeeDao.find(id);
        return emp;
    }

    @Override
    public Employee update(Employee employee) {

        return employeeDao.update(employee);
    }

    @Override
    public String delete(Integer id) {
        Optional<Employee> emp=findById(id);
        if(emp.isPresent()){
            employeeDao.delete(id);
            return "Data is deleted";
        }else{
            return "Invalid id";
        }

    }
}
