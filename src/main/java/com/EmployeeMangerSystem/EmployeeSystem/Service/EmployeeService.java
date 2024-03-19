package com.EmployeeMangerSystem.EmployeeSystem.Service;


import com.EmployeeMangerSystem.EmployeeSystem.Exceptions.UserNotFoundException;
import com.EmployeeMangerSystem.EmployeeSystem.Model.Employee;
import com.EmployeeMangerSystem.EmployeeSystem.repo.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository empRepo;
    @Autowired
    public EmployeeService(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    public Employee AddEmployee(Employee E){
        E.setEmployeeCode(UUID.randomUUID().toString());
        return empRepo.save(E);
    }

    public List<Employee> EmployeeList(){
        return empRepo.findAll();
    }

    public Employee UpdateEmployee(Employee employee){
        return empRepo.save(employee);
    }

    public Employee FindEmployeeById(Long Id) throws UserNotFoundException {
        return empRepo.findEmployeeById(Id).orElseThrow(()->new UserNotFoundException("Employee Not Found"));
    }

    public void DeleteEmployeeById(Long id){
         empRepo.deleteEmployeeById(id);
    }




}
