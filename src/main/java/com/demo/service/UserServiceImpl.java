package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.Dao.IUserRepository;
import com.demo.entity.User;

@Service
public class UserServiceImpl implements IUserService {

	private IUserRepository userRepository;
	

	public UserServiceImpl(IUserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(int theId) {
		Optional<User>result=userRepository.findById(theId);
		User theUser=null;
		if(result.isPresent()) {
			theUser=result.get();
		}
		else {
			throw new RuntimeException("Did not find User Id "+theId);
		}
		return theUser;
	}

	@Override
	public void save(User theUser) {
		userRepository.save(theUser);
		
	}

	@Override
	public void deleteById(int theId) {
		userRepository.deleteById(theId);	
	}

	@Override
	public User findUserByUserNameAndPassword(String userName, String password) {
		User user = userRepository.findUserByUserNameAndPassword(userName, password);
		if(user==null) {
			return null;
		}
		return user;
	}
}
