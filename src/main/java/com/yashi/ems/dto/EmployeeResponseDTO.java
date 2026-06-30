package com.yashi.ems.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {
	private Integer id;
	private String name;
	private String email;
	private double salary;
	private String departmentName;
	
	public EmployeeResponseDTO() {}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public double getSalary() {
		return salary;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setSalary(double salary) {
		this.salary=salary;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName=departmentName;
	}
	@Override
	public String toString() {
		return "EmployeeResponseDTO{"+" id: "+id+
				"name: "+name+ " email: "+email+
				" salary: "+salary+"departmentName: "
				+departmentName+" }";
	}

}
