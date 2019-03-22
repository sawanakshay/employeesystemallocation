package com.analog.employeesystemallocation.dto.mapper;

import com.analog.employeesystemallocation.dto.EmployeeSystemDto;
import com.analog.employeesystemallocation.model.EmployeeSystem;

public class EmployeeSystemDtoMapper {
	
	public EmployeeSystemDtoMapper() {
		// TODO Auto-generated constructor stub
	}
	
	public static EmployeeSystem toEmployeeSystem(EmployeeSystemDto employeeSystemDto) {
		EmployeeSystem employeeSystem = new EmployeeSystem();
		employeeSystem.setEmployee(employeeSystemDto.getEmployee());
		employeeSystem.setSystem(employeeSystemDto.getSystem());
		employeeSystem.setIsActive(true);
		return employeeSystem;
	}
	
	public static EmployeeSystemDto toEmployeeSystemDto(EmployeeSystem employeeSystem) {
		EmployeeSystemDto employeeSystemDto = new EmployeeSystemDto();
		employeeSystemDto.setId(employeeSystem.getId());
		employeeSystemDto.setIsActive(employeeSystem.getIsActive());
		employeeSystemDto.setEmployee(employeeSystem.getEmployee());
		employeeSystemDto.setSystem(employeeSystem.getSystem());
		return employeeSystemDto;
	}
	
	public static EmployeeSystem toEmployeeSystem(EmployeeSystem employeeSystem, EmployeeSystemDto employeeSystemDto) {
		employeeSystem.setIsActive(true);
		employeeSystem.setEmployee(employeeSystemDto.getEmployee()!=null ? employeeSystemDto.getEmployee() : employeeSystem.getEmployee());
		employeeSystem.setSystem(employeeSystemDto.getSystem()!=null ? employeeSystemDto.getSystem() : employeeSystem.getSystem());
		return employeeSystem;
	}
}
