package com.crpdev.springcrud.service;

import com.crpdev.springcrud.model.Employee;
import com.crpdev.springcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rajapandian
 * Date: 25/05/20
 * Project: spring-crud
 * Package: com.crpdev.springcrud.service
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    // Autowired is not mandatory on constructors post Spring 3.5
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee createNewEmployee(Employee newEmployee){
        Employee savedEmployee = employeeRepository.save(newEmployee);
        return savedEmployee;
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employee.setEmail(updatedEmployee.getEmail());
            return employee;
        }).orElseGet(() -> {
                updatedEmployee.setId(id);
                return employeeRepository.save(updatedEmployee);
        });
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

}
