package com.yashi.ems.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="departments")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="department_name",nullable=false)
	@NotBlank(message="Department Name is required")
	private String departmentName;
	@OneToMany(mappedBy="department")
	@JsonIgnore
	private List<Employee> employees;
	public Department() {}
	
	public Department(String departmentName) {
		this.departmentName=departmentName;
	}
	
	public Integer getId() {
		return id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public List<Employee> getEmployees(){
		return employees;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName=departmentName;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees=employees;
	}
	
	@Override
	public String toString() {
		return "Department{"+
				"id="+id+
				",departmentName='"+departmentName+'\''+
				'}';
	}

}
