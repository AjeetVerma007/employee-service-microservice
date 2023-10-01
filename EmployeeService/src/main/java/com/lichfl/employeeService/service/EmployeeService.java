package com.lichfl.employeeService.service;

import com.lichfl.employeeService.dto.ApiResponseDto;
import com.lichfl.employeeService.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employeeDto);

	ApiResponseDto getEmployeeById(Long id);
}
