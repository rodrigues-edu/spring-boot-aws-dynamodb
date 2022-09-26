package com.example.dynamodb.web;

import com.example.dynamodb.domain.Employee;
import com.example.dynamodb.exception.DataNotFoundException;
import com.example.dynamodb.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping()
    public List<Employee> all() {
        return employeeService.getAll();

    }

    @PostMapping()
    public Employee save(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping(value = "/{id}")
    public Employee update(@PathVariable("id") String id, @RequestBody Employee employee) {
        return employeeService.update(employee,id);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") String id) {
        return employeeService.getById(id).orElseThrow(() -> new DataNotFoundException("not found"));
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable(value = "id") String id) {
        employeeService.delete(id);
    }

}
