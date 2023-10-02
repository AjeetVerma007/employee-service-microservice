package com.lichfl.employeeService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto {

	private DepartmentDto department;
	private EmployeeDto employee;
	private OrganizationDto organization;

}
