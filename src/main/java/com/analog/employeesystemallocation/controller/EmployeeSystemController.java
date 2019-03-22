package com.analog.employeesystemallocation.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.analog.employeesystemallocation.dto.ResponseDto;
import com.analog.employeesystemallocation.dto.EmployeeSystemDto;
import com.analog.employeesystemallocation.dto.mapper.EmployeeSystemDtoMapper;
import com.analog.employeesystemallocation.model.EmployeeSystem;
import com.analog.employeesystemallocation.service.EmployeeSystemService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/employeesystem")
class EmployeeSystemController {
	
	@Autowired
	private EmployeeSystemService employeeSystemService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployeeSystemList() {
		ResponseDto dto = new ResponseDto();
			List<EmployeeSystemDto> employeeSystems = employeeSystemService.getEmployeeSystems().parallelStream().filter(Objects::nonNull)
					.map(EmployeeSystemDtoMapper::toEmployeeSystemDto).collect(Collectors.toList());
			if(!employeeSystems.isEmpty()) {
				return new ResponseEntity<List<EmployeeSystemDto>>(employeeSystems, HttpStatus.OK);
			}else {
				dto.setResponseMessage("No employeeSystems are available");
				return new ResponseEntity<ResponseDto>(dto,  HttpStatus.NOT_FOUND);
			}
	}
	
	
}
