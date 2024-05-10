package com.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
