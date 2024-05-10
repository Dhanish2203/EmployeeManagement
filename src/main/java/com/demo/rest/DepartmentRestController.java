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

import com.demo.entity.Department;
import com.demo.entity.Employee;
import com.demo.service.DepartmentService;
import com.demo.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class DepartmentRestController {
	private DepartmentService departmentService;

	@Autowired
public DepartmentRestController(DepartmentService thedepartmentService) {
		departmentService = thedepartmentService;
}
	
	@GetMapping("/departments")
	public List<Department>findAll(){
		return departmentService.findAll();
		}
	
	@GetMapping("/departments/{departmentId}")
	public Department getDepartment(@PathVariable int departmentId){
		Department theDepartment=departmentService.findById(departmentId);
        if(theDepartment==null) {
        	throw new RuntimeException("department id not found-"+departmentId);
        }
        return theDepartment;	
}
	
	@PostMapping("/departments")
	public Department addDepartment(@RequestBody Department theDepartment){
		theDepartment.setDepartmentId(0);
		departmentService.save(theDepartment);
		return theDepartment;
		
	}
	
	@PutMapping("/departments/{departmentId}")
	public Department updateDepartment(@PathVariable int departmentId,@RequestBody Department theDepartment) {
		Department det=departmentService.findById(departmentId);
		 if(det==null) {
	        	throw new RuntimeException("department id not found-"+departmentId);
	        }

		 
//		 emp.setEmployeeName(theEmployee.getEmployeeName());
//		 emp.setDesignation(theEmployee.getDesignation());
//		 emp.setDateOfJoing(theEmployee.getDateOfJoing());
//		 emp.setDepartment(theEmployee.getDepartment());
		 
		 det.setDepartmentId(theDepartment.getDepartmentId());
		 det.setDepartmentName(theDepartment.getDepartmentName());
		 departmentService.save(det);
		return det;
	}
	
	@DeleteMapping("/departments/{departmentId}")
	public String deleteDepartment(@PathVariable int departmentId){
		Department theDepartment=departmentService.findById(departmentId);
        if(theDepartment==null) {
        	throw new RuntimeException("department id not found-"+departmentId);
        }
        departmentService.deleteById(departmentId);
        return "Deleted departmentId: "+departmentId;	 
	
}
}
