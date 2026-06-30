package com.yashi.ems.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class EmployeeRequestDTO {
	@NotBlank(message="Name is Required")
	private String name;
	@NotBlank(message="Email is required")
	@Email
	private String email;
	@Positive(message="Salary should be more than 0")
	private double salary;
	@NotNull(message="department id is required")
	private Integer departmentId;
	
	public EmployeeRequestDTO() {}
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public double getSalary() {
		return salary;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	
	public void setName(String name) {
		this.name= name;
	}
	public void setEmail(String email) {
		this.email= email;
	}
	public void setSalary(double salary) {
		this.salary= salary;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId= departmentId;
	}
	
	@Override
	public String toString() {
	    return "EmployeeRequestDTO{" +
	            "name='" + name + '\'' +
	            ", email='" + email + '\'' +
	            ", salary=" + salary +
	            ", departmentId=" + departmentId +
	            '}';
	}
}
