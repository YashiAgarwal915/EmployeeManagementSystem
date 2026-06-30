package com.yashi.ems.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yashi.ems.dto.EmployeeResponseDTO;
import com.yashi.ems.entity.Employee;
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	List<Employee> findByNameContaining(String name);
	Optional<Employee> findByEmail(String email);
	List<Employee> findByDepartmentDepartmentName(String departmentName);
}
