package com.demo.service;

import java.util.List;

import com.demo.entity.Department;



public interface DepartmentService {

	public abstract List<Department>findAll();
	public abstract Department findById(int theId);
	public abstract void save(Department theDepartment);
	public abstract void deleteById(int theId);
}
