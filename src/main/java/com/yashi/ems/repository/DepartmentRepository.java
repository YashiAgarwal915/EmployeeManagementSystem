package com.yashi.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yashi.ems.entity.Department;
public interface DepartmentRepository extends JpaRepository<Department,Integer>{
	@Query("select d from Department d where d.departmentName like %:keyword%")
	List<Department> searchDepartment(@Param("keyword") String keyword);
}
