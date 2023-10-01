package com.lichfl.employeeService.service.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lichfl.employeeService.dto.DepartmentDto;

//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
//adding load balancer hence using service name
@FeignClient(name = "DEPARTMENT-SERVICE") 
public interface APIClient {

	@GetMapping("api/departments/{department-code}")
	DepartmentDto getDepartmentByCode(@PathVariable("department-code") String departmentCode);

}
