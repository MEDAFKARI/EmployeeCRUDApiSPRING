package com.EmployeeMangerSystem.EmployeeSystem.Controller;


import com.EmployeeMangerSystem.EmployeeSystem.Exceptions.UserNotFoundException;
import com.EmployeeMangerSystem.EmployeeSystem.Model.Employee;
import com.EmployeeMangerSystem.EmployeeSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService EmpService;
    @Autowired
    public EmployeeController(EmployeeService E){
        this.EmpService= E;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> Employees = EmpService.EmployeeList();
        return new ResponseEntity<List<Employee>>(Employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) throws UserNotFoundException {
        Employee Emp = EmpService.FindEmployeeById(id);
        return new ResponseEntity<Employee>(Emp, HttpStatus.OK);
    }

    @PostMapping ("/Add")
    public ResponseEntity<Employee> AddEmployee(@RequestBody Employee employee) {
        Employee Emp = EmpService.AddEmployee(employee);
        return new ResponseEntity<Employee>(Emp, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> UpdateEmployee(@RequestBody Employee employee){
        Employee emp = EmpService.UpdateEmployee(employee);
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteEmployee(@PathVariable("id") Long Id){
        EmpService.DeleteEmployeeById(Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
