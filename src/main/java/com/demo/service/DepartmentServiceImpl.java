package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.Dao.IDepartmentRepository;
import com.demo.entity.Department;


@Service
public class DepartmentServiceImpl implements DepartmentService {

	
	private  IDepartmentRepository  iDepartmentRepository;
	
	
	public DepartmentServiceImpl(IDepartmentRepository iDepartmentRepository) {
		super();
		this.iDepartmentRepository = iDepartmentRepository;
	}

	@Override
	public List<Department> findAll() {
		return  iDepartmentRepository.findAll();
	}

	@Override
	public Department findById(int theId) {
		Optional<Department>result=iDepartmentRepository.findById(theId);
		Department department=null;
		if(result.isPresent()) {
			department=result.get();
		}
		else {
			throw new RuntimeException("Did not find employee Id "+theId);
		}
		return department;
	}

	@Override
	public void save(Department theDepartment) {
		iDepartmentRepository.save(theDepartment);
	}

	@Override
	public void deleteById(int theId) {
		iDepartmentRepository.deleteById(theId);
		
	}

}
