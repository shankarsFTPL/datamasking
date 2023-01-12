package com.mask.masking.model;


import com.mask.masking.utility.MaskUtility;

public class EmployeeSalaryPojo extends MaskUtility{
	
	private String name;
	private String email;
	private String mobile;
	private String salary;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeSalaryPojo [name=" + name + ", email=" + email + ", mobile=" + mobile + ", salary=" + salary
				+ "]";
	}
	
	
	

}
