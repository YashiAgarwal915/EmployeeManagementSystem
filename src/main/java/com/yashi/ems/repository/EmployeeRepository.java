package com.yashi.ems.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yashi.ems.entity.Employee;
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
