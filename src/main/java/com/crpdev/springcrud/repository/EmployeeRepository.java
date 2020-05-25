package com.crpdev.springcrud.repository;

import com.crpdev.springcrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajapandian
 * Date: 25/05/20
 * Project: spring-crud
 * Package: com.crpdev.springcrud.repository
 **/
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
