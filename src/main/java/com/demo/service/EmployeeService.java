package com.demo.service;

import java.util.List;

import com.demo.entity.Employee;

public interface EmployeeService {

	public abstract List<Employee>findAll();
	public abstract Employee findById(int theId);
	public abstract void save(Employee theEmployee);
	public abstract void deleteById(int theId);
}
