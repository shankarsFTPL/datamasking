package com.mask.masking.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.mask.masking.entities.Employee;
import com.mask.masking.model.EmployeeSalaryPojo;

public interface EmployeeService {

	List<Employee> getAllEmployeeas();

	Employee getEmployee(int id);

	List<EmployeeSalaryPojo> getEmployeeSalaries();

	List<Employee> employeeList();

	List<Employee> allEmployeeList();

	ResponseEntity<Map<String, Object>> getEmployeeDetails(int page, int size);

}
