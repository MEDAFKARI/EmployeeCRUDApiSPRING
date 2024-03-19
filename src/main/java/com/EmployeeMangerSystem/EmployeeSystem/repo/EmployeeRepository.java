package com.EmployeeMangerSystem.EmployeeSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EmployeeMangerSystem.EmployeeSystem.Model.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
