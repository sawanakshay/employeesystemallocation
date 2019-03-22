package com.analog.employeesystemallocation.dto;

public class EmployeeSystemDto extends AppBaseDto{
	
	private String employee;
	private String system;
	
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}	
	
}
