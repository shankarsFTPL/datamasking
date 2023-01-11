package com.mask.masking.services;

import java.util.List;

import com.mask.masking.entities.Employee;
import com.mask.masking.model.EmployeeSalaryPojo;

public interface EmployeeService {

	List<Employee> getAllEmployeeas();

	Employee getEmployee(int id);

	List<EmployeeSalaryPojo> getEmployeeSalaries();

	List<Employee> employeeList();

	List<Employee> allEmployeeList();

}
