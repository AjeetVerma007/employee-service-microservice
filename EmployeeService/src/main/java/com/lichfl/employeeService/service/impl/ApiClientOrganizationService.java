package com.lichfl.employeeService.service.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lichfl.employeeService.dto.OrganizationDto;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface ApiClientOrganizationService {

	@GetMapping("api/organizations/{code}")
	OrganizationDto getOrganizationByCode(@PathVariable("code") String oganizationCode);

}
