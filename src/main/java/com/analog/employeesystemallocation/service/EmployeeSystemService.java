package com.analog.employeesystemallocation.service;

import java.util.List;

import com.analog.employeesystemallocation.dto.EmployeeSystemDto;
import com.analog.employeesystemallocation.model.EmployeeSystem;

public interface EmployeeSystemService {
	
	public List<EmployeeSystem> getEmployeeSystems();
	
}
