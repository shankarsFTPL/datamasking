package com.mask.masking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mask.masking.entities.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {

}
