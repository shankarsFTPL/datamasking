package com.mask.masking.entities;

import java.util.Arrays;

import com.mask.masking.utility.MaskUtility;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "salary")
public class Salary extends MaskUtility {
	
	@Id
	private Integer id;
	private String salary;
	@ManyToOne
    @JoinColumn(name = "empid")
    private Employee employee;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSalary() {
		return Arrays.asList(field).contains("salary") ? replaceField(salary) : salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Salary [id=" + id + ", salary=" + salary + ", employee=" + employee + "]";
	}
	
	
	
	

}
