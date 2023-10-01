package com.lichfl.employeeService.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.lichfl.employeeService.dto.ApiResponseDto;
import com.lichfl.employeeService.dto.DepartmentDto;
import com.lichfl.employeeService.dto.EmployeeDto;
import com.lichfl.employeeService.entity.Employee;
import com.lichfl.employeeService.repository.EmployeeRepository;
import com.lichfl.employeeService.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepository employeeRepository;

	/*
	 * @Autowired RestTemplate restTemplate;
	 */

	/*
	 * @Autowired WebClient webClient;
	 */

	APIClient apiClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		Employee savedEmployee = employeeRepository.save(employee);
		EmployeeDto savedEmployeeDto = new EmployeeDto();
		BeanUtils.copyProperties(savedEmployee, savedEmployeeDto);

		return savedEmployeeDto;
	}

	@Override
	public ApiResponseDto getEmployeeById(Long id) {

		Employee employee = employeeRepository.findById(id).get();

		// Get department data using Rest Template

		/*
		 * ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
		 * "http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
		 * DepartmentDto.class);
		 * 
		 * DepartmentDto departmentDto = responseEntity.getBody();
		 */

		// Fetch Department data using webClient
		/*
		 * DepartmentDto departmentDto = webClient.get()
		 * .uri("http://localhost:8080/api/departments/" +
		 * employee.getDepartmentCode()).retrieve()
		 * .bodyToMono(DepartmentDto.class).block();
		 */

		// Fetch Department data using FeignClient

		DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

		// Get Employee data
		EmployeeDto employeeDto = new EmployeeDto();
		BeanUtils.copyProperties(employee, employeeDto);

		ApiResponseDto apiResponseDto = new ApiResponseDto();

		apiResponseDto.setDepartment(departmentDto);
		apiResponseDto.setEmployee(employeeDto);

		return apiResponseDto;
	}

}
