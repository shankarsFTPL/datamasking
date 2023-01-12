package com.mask.masking.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mask.masking.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "SELECT * FROM Employee ", nativeQuery = true)
	Page<Employee> findAllEmployees(Pageable pageable);



}
