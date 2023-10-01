package com.lichfl.employeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lichfl.employeeService.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
