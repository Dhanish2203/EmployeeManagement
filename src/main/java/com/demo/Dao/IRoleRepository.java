package com.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Role;


public interface IRoleRepository extends JpaRepository<Role, Integer>{
	
}

