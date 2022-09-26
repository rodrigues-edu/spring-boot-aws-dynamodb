package com.example.dynamodb.service;

import com.example.dynamodb.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {


    /**
     * create new employee
     */
    Employee create(Employee employee);

    /**
     * Update employee data
     */
    Employee update(Employee employee, String id);


    /**
     * get Employee by id
     */
    Optional<Employee> getById(String id);

    /**
     * Get all entities
     */
    List<Employee> getAll();

    void delete(String id);
}
