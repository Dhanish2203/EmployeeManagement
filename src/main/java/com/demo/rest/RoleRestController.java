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

import com.demo.entity.Role;
import com.demo.service.IRoleService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RoleRestController {
	private IRoleService roleService;

	@Autowired
	public RoleRestController(IRoleService theroleService) {
		roleService = theroleService;
	}

	@GetMapping("/roles")
	public List<Role> findAll() {
		return roleService.findAll();
	}

	@GetMapping("/roles/{roleId}")
	public Role getRole(@PathVariable int roleId) {
		Role theRole = roleService.findById(roleId);
		if (theRole == null) {
			throw new RuntimeException("role id not found-" + roleId);
		}
		return theRole;
	}

	@PostMapping("/roles")
	public Role addRole(@RequestBody Role theRole) {
		theRole.setRoleId(0);
		roleService.save(theRole);
		return theRole;

	}

	@PutMapping("/roles/{roleId}")
	public Role updateRole(@PathVariable int roleId, @RequestBody Role theRole) {
		Role det = roleService.findById(roleId);
		if (det == null) {
			throw new RuntimeException("role id not found-" + roleId);
		}

//		 emp.setEmployeeName(theEmployee.getEmployeeName());
//		 emp.setDesignation(theEmployee.getDesignation());
//		 emp.setDateOfJoing(theEmployee.getDateOfJoing());
//		 emp.setDepartment(theEmployee.getDepartment());

		det.setRoleId(theRole.getRoleId());
		det.setRoleName(theRole.getRoleName());
		roleService.save(det);
		return det;
	}

	@DeleteMapping("/roles/{roleId}")
	public String deleteRole(@PathVariable int roleId) {
		Role theRole = roleService.findById(roleId);
		if (theRole == null) {
			throw new RuntimeException("role id not found-" + roleId);
		}
		roleService.deleteById(roleId);
		return "Deleted roleId: " + roleId;

	}
}
