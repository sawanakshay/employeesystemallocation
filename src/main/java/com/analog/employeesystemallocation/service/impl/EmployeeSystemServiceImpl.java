package com.analog.employeesystemallocation.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analog.employeesystemallocation.dto.EmployeeSystemDto;
import com.analog.employeesystemallocation.dto.mapper.EmployeeSystemDtoMapper;
import com.analog.employeesystemallocation.model.EmployeeSystem;
import com.analog.employeesystemallocation.repository.EmployeeSystemRepository;
import com.analog.employeesystemallocation.service.EmployeeSystemService;

@Service
public class EmployeeSystemServiceImpl implements EmployeeSystemService{

	@Autowired
	private EmployeeSystemRepository employeeSystemRepository;
	
	public List<EmployeeSystem> getEmployeeSystems() {
		return employeeSystemRepository.getAllEmployeeSystems();
	}

	
}
