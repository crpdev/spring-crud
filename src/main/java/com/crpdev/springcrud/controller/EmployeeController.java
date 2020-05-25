package com.crpdev.springcrud.controller;

import com.crpdev.springcrud.model.Employee;
import com.crpdev.springcrud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rajapandian
 * Date: 25/05/20
 * Project: spring-crud
 * Package: com.crpdev.springcrud.controller
 **/
@RestController
@RequestMapping(value = "/employee-management/api")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    Employee createNewEmployee(@RequestBody Employee newEmployee) {
        return employeeService.createNewEmployee(newEmployee);
    }

    @GetMapping("/employees/{id}")
    Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return employeeService.updateEmployee(id, newEmployee);
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }

}
