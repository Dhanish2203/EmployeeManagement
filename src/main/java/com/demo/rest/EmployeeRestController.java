package com.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.demo.dao.EmployeeDao;
import com.demo.entity.Employee;
import com.demo.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
public EmployeeRestController(EmployeeService theEmployeeService) {
	employeeService = theEmployeeService;
}
	
	@GetMapping("/employees")
	public List<Employee>findAll(){
		return employeeService.findAll();
		}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId){
		Employee theEmployee=employeeService.findById(employeeId);
        if(theEmployee==null) {
        	throw new RuntimeException("employee id not found-"+employeeId);
        }
        return theEmployee;	
}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee){
//		theEmployee.setId(0);
		theEmployee.setEmployeeid(0);
		employeeService.save(theEmployee);
		return theEmployee;
		
	}
	
	@PutMapping("/employees/{employeeId}")
	public Employee updateEmployee(@PathVariable int employeeId,@RequestBody Employee theEmployee) {
		Employee emp=employeeService.findById(employeeId);
		 if(theEmployee==null) {
	        	throw new RuntimeException("employee id not found-"+employeeId);
	        }

		 
		 emp.setEmployeeName(theEmployee.getEmployeeName());
		 emp.setDesignation(theEmployee.getDesignation());
		 emp.setDateOfJoing(theEmployee.getDateOfJoing());
		 emp.setDepartment(theEmployee.getDepartment());
		employeeService.save(emp);
		return emp;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId){
		Employee theEmployee=employeeService.findById(employeeId);
        if(theEmployee==null) {
        	throw new RuntimeException("employee id not found-"+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employeeId: "+employeeId;	 
	
}
}
