package com.mask.masking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mask.masking.entities.Employee;
import com.mask.masking.model.EmployeeSalaryPojo;
import com.mask.masking.services.EmployeeService;

@RestController
@RequestMapping(value="/api")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	@Autowired



	@GetMapping(value="/maskData")
	public List<Employee> getEmployees(){
	
		return empService.getAllEmployeeas();
	}
	
	@GetMapping(value = "/maskData/{id}")
	public Employee getEmployees(@PathVariable int id){
		
		return empService.getEmployee(id);
		
	}
	
	@GetMapping(value = "/empSal")
	public List<EmployeeSalaryPojo> employeeSalary(){
		return empService.getEmployeeSalaries();
	}
	
	@GetMapping(value = "/empList")
	public List<Employee> allEmployeeList(){
		return empService.employeeList();
	}
	
	@GetMapping(value = "/empListHiCri")
	public List<Employee> getAllList(){
		return empService.allEmployeeList();
	}
	
	@GetMapping(value = "/empListPage")
	public ResponseEntity<Map<String, Object>> employeeDetails(@RequestParam int page, @RequestParam int size){
		
		return empService.getEmployeeDetails(page,size);
		
	}
}
