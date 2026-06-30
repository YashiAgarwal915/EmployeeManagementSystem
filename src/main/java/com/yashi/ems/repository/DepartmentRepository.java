package com.yashi.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yashi.ems.entity.Department;
public interface DepartmentRepository extends JpaRepository<Department,Integer>{

}
