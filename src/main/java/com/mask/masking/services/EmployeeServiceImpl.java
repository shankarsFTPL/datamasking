package com.mask.masking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mask.masking.utility.MaskUtility;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mask.masking.entities.Employee;
import com.mask.masking.entities.Salary;
import com.mask.masking.model.EmployeeSalaryPojo;
import com.mask.masking.repositories.EmployeeRepository;
import com.mask.masking.repositories.SalaryRepository;
import com.mask.masking.utility.Masking;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	@Autowired
	Masking masking;
	@Autowired
	MaskUtility maskUtil;
	@Autowired
	SalaryRepository salRepo;
	@PersistenceContext
	EntityManager repo;

	@Override
	public List<Employee> getAllEmployeeas() {
		try {
			maskUtil.getFields(masking.getMaskingFields("Employee").stream().map(String::trim).toArray(String[]::new));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployee(int id) {
		try {
			maskUtil.getFields(masking.getMaskingFields("Employee").stream().map(String::trim).toArray(String[]::new));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empRepo.findById(id).get();
	}

	@Override
	public List<EmployeeSalaryPojo> getEmployeeSalaries() {
		
		List<EmployeeSalaryPojo> finalList = new ArrayList<>();
		

		maskUtil.getFields( Stream.of(masking.getMaskingFields("Salary"),masking.getMaskingFields("Employee")).flatMap(Collection::stream).collect(Collectors.toList()).stream().map(String::trim)
		        .toArray(String[]::new));
		
		List<Salary> allList1 = salRepo.findAll();
		
		
		for (Salary salary : allList1) {
			EmployeeSalaryPojo pojo = new EmployeeSalaryPojo();
			
			pojo.setEmail(salary.getEmployee().getEmail());
			pojo.setMobile(salary.getEmployee().getMobile());
			pojo.setName(salary.getEmployee().getName());
			pojo.setSalary(salary.getSalary());
			finalList.add(pojo);
			
		}
		return finalList;
	}

	@Override
	public List<Employee> employeeList() {
		maskUtil.getFields(masking.getMaskingFields("Employee").stream().map(String::trim).toArray(String[]::new));
		String query = "SELECT e FROM Employee e";
		TypedQuery<Employee> empList = repo.createQuery(query,Employee.class);
		return empList.getResultList();
	}

	@Override
	public List<Employee> allEmployeeList() {
		maskUtil.getFields(masking.getMaskingFields("Employee").stream().map(String::trim).toArray(String[]::new));
		CriteriaBuilder cb = repo.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		
		return repo.createQuery(cq).getResultList();
	}

	@Override
	public ResponseEntity<Map<String, Object>> getEmployeeDetails(int page, int size) {
		Pageable pageable =  PageRequest.of(page, size);
		Page<Employee> paging = empRepo.findAll(pageable);
		
		Map<String, Object> response = new HashMap<>();
		response.put("currentpage", paging.getNumber());
		response.put("totalItems", paging.getContent());
		response.put("totalpages", paging.getTotalPages());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
