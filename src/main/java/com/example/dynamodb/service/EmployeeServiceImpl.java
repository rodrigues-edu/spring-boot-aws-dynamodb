package com.example.dynamodb.service;

import com.example.dynamodb.domain.Employee;
import com.example.dynamodb.exception.DataNotFoundException;
import com.example.dynamodb.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee update(Employee employee, String id) {

        Optional<Employee> employeeOptional = repository.findById(id);
        if (employeeOptional.isPresent()) {
            employeeOptional.get().setFirstName(employee.getFirstName());
            employeeOptional.get().setLastName(employee.getLastName());
            employeeOptional.get().setEmail(employee.getEmail());
            employeeOptional.get().setNumber(employee.getNumber());
            employeeOptional.get().setDepartment(employee.getDepartment());

            return repository.save(employeeOptional.get());
        }
        throw new DataNotFoundException("Employee Id not found");
    }

    @Override
    public Optional<Employee> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Employee> getAll() {
        return (List<Employee>) repository.findAll();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
