package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.Dao.IRoleRepository;
import com.demo.entity.Role;

@Service
public class RoleServiceImpl implements IRoleService{

	private  IRoleRepository  iRoleRepository;

	
	public RoleServiceImpl(IRoleRepository iRoleRepository) {
		super();
		this.iRoleRepository = iRoleRepository;
	}

	@Override
	public List<Role> findAll() {
		return  iRoleRepository.findAll();

	}

	@Override
	public Role findById(int theId) {
		Optional<Role>result=iRoleRepository.findById(theId);
		Role role=null;
		if(result.isPresent()) {
			role=result.get();
		}
		else {
			throw new RuntimeException("Did not find User Id "+theId);
		}
		return role;
	}

	@Override
	public void save(Role theRole) {
		iRoleRepository.save(theRole);
		
	}

	@Override
	public void deleteById(int theId) {
		iRoleRepository.deleteById(theId);
		
	}

}
