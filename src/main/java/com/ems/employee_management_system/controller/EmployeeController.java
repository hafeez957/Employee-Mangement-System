package com.ems.employee_management_system.controller;

import com.ems.employee_management_system.entity.Employee;
import com.ems.employee_management_system.exceptions.NameNullException;
import com.ems.employee_management_system.responseformat.ResponseStructure;
import com.ems.employee_management_system.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Employee>> save(@RequestBody Employee employee){
        ResponseStructure<Employee> rs=new ResponseStructure<>();
        if(employee.getName()!=null){
            Employee emp= employeeService.save(employee);
            rs.setStatuscode(HttpStatus.CREATED.value());
            rs.setMessage("Data inserted successfully");
            rs.setData(emp);

            return new ResponseEntity<>(rs,HttpStatus.CREATED);
        }else{
            throw new NameNullException("Name cannot be empty");
        }
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Employee>>> findAll(){
        ResponseStructure<List<Employee>> rs=new ResponseStructure<>();

            List<Employee> emp= employeeService.findAll( );
            rs.setStatuscode(HttpStatus.FOUND.value());
            rs.setMessage("Data found successfully");
            rs.setData(emp);

            return new ResponseEntity<>(rs,HttpStatus.FOUND);

    }
}
