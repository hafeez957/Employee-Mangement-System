package com.ems.employee_management_system.responseformat;

import lombok.Data;

@Data
public class ResponseStructure<T> {

    private Integer statuscode;
    private String message;
    private T data;
}
