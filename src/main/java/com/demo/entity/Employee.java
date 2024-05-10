package com.demo.entity;

import java.util.Date; 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="empId")
	private int employeeid;
	private String employeeName;
	private String designation;
	private Date dateOfJoing;
	
	//mapping
	private int departmentId;
	
	  public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	@ManyToOne
	    @JoinColumn(name = "departmentId", insertable=false, updatable=false)
	    private Department department;
	  public Employee(int employeeid, String employeeName, String designation, Date dateOfJoing, Department department) {
	        this.employeeid = employeeid;
	        this.employeeName = employeeName;
	        this.designation = designation;
	        this.dateOfJoing = dateOfJoing;
	        this.department = department;
	    }

	public Employee() {
		super();
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getDateOfJoing() {
		return dateOfJoing;
	}
	public void setDateOfJoing(Date dateOfJoing) {
		this.dateOfJoing = dateOfJoing;
	}
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
	
	
}
