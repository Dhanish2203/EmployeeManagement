package com.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.demo.entity.User;

public interface IUserService {
	public abstract List<User>findAll();
	public abstract User findById(int theId);
	public abstract void save(User theUser);
	public abstract void deleteById(int theId);
	//@Query("from User where userName=?1 and password=?2")
	public abstract User findUserByUserNameAndPassword(String userName, String password);
}
