package com.mask.masking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mask.masking.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {



}
