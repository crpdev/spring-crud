package com.crpdev.springcrud.service;

import com.crpdev.springcrud.model.Employee;

import java.util.List;

/**
 * Created by rajapandian
 * Date: 25/05/20
 * Project: spring-crud
 * Package: com.crpdev.springcrud.service
 **/

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee createNewEmployee(Employee newEmployee);

    public Employee getEmployeeById(Long id);

    public Employee updateEmployee (Long id, Employee employee);

    public void deleteEmployeeById (Long id);

}
