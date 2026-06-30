package com.yashi.ems.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="employee_name", nullable=false)
	@NotBlank(message="Employee is Required")
	private String name;
	@Column(name="employee_email", nullable=false)
	@NotBlank(message="Email is required")
	@Email(message="Invalid email format")
	private String email;
	@ManyToOne
	@JoinColumn(name="department_id")
	@NotNull(message="Department is required")
	private Department department;
	@Positive(message="Salary must be greater than 0")
	@Column(name="employee_salary", nullable=false)
	private double salary;
	
	public Employee() {}
	
	public  Employee(String name,String email,Department department, double salary) {
		this.name=name;
		this.email=email;
		this.department=department;
		this.salary=salary;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Department getDepartment() {
		return department;
	}
	public double getSalary() {
		return salary;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setDepartment(Department department) {
		this.department=department;
	}
	public void setSalary(double salary) {
		this.salary=salary;
	}
	
	@Override
	public String toString() {
		return "Employee{" +
			   "id=" +id +
			   ", name='" +name+ '\''+
			   ", email='"+email+ '\''+
	            ", salary=" + salary +
	            '}';
	}	
}
