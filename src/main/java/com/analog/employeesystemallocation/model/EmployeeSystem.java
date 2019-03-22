package com.analog.employeesystemallocation.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employeesystem")
public class EmployeeSystem extends BaseModel{
	
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
