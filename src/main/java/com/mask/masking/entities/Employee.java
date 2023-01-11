package com.mask.masking.entities;

import java.util.Arrays;

import com.mask.masking.utility.MaskUtility;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends MaskUtility {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String mobile;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return Arrays.asList(field).contains("name") ? replaceField(name) : name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Arrays.asList(field).contains("email") ? replaceField(email) : email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return Arrays.asList(field).contains("mobile") ? replaceField(mobile) : mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
	}
	
	
	
	
}
