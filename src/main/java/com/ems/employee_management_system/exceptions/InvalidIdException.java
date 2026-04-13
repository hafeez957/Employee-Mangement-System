package com.ems.employee_management_system.exceptions;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String idNotFound) {
        super(idNotFound);
    }
}
