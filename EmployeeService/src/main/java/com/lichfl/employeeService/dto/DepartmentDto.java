package com.lichfl.employeeService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {

	private Long id;
	private String departmentName;
	private String departmentDescription;
	private String departmentCode;

}
