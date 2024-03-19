package com.EmployeeMangerSystem.EmployeeSystem.Exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String employeeNotFound) {
        super(employeeNotFound);
    }
}
