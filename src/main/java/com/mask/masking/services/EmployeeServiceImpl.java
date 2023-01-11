package com.mask.masking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mask.masking.utility.MaskUtility;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
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

}
