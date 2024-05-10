package com.demo.service;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.Dao.EmployeeRepository;

import com.demo.entity.Employee;

@Service
public class EmployeeSeviceImpl implements EmployeeService{
	

	private EmployeeRepository employeeRepository;
	
	
	public EmployeeSeviceImpl(EmployeeRepository employeeRepository) {
	super();
	this.employeeRepository = employeeRepository;
}



	@Override
	
	public List<Employee> findAll() {
		
		return employeeRepository.findAll()
;	}

	

	@Override
	
	public Employee findById(int theId) {
		Optional<Employee>result=employeeRepository.findById(theId);
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee=result.get();
		}
		else {
			throw new RuntimeException("Did not find employee Id "+theId);
		}
		return theEmployee;
	}

	@Override
	
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
		
		
	}

	@Override
	
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
		
	}

}
