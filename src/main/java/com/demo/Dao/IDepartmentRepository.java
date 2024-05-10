package com.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Department;







public interface IDepartmentRepository extends JpaRepository<Department, Integer>{
	
}
