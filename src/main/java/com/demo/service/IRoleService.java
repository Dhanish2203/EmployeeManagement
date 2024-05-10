package com.demo.service;

import java.util.List;

import com.demo.entity.Role;

public interface IRoleService {
	public abstract List<Role>findAll();
	public abstract Role findById(int theId);
	public abstract void save(Role theRole);
	public abstract void deleteById(int theId);
}
