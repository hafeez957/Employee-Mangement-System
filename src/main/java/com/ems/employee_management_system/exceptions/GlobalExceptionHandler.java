package com.ems.employee_management_system.exceptions;

import com.ems.employee_management_system.entity.Employee;
import com.ems.employee_management_system.responseformat.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NameNullException.class)
    public ResponseEntity<ResponseStructure<Employee>> nameNullExceptionHandler(NameNullException e){
        ResponseStructure<Employee> rs=new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
        rs.setMessage("Name is empty");
        rs.setData(null);

        return new ResponseEntity<>(rs,HttpStatus.BAD_REQUEST);
    }
}
