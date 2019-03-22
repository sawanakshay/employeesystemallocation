package com.analog.employeesystemallocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.analog.employeesystemallocation.model.EmployeeSystem;

@Repository
public interface EmployeeSystemRepository extends JpaRepository<EmployeeSystem, Long>{
	
	@Query("FROM EmployeeSystem employeeSystem WHERE employeeSystem.isActive = 1 order by employeeSystem.system")
	public List<EmployeeSystem> getAllEmployeeSystems();
	
}
