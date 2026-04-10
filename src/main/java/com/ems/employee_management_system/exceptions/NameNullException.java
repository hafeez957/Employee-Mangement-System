package com.ems.employee_management_system.exceptions;

public class NameNullException extends RuntimeException {
    public NameNullException(String nameCannotBeEmpty) {
        super(nameCannotBeEmpty);
    }
}
