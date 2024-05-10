package com.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entity.User;


public interface IUserRepository extends JpaRepository<User, Integer> {

	@Query(" from User  WHERE userName = ?1 AND password = ?2")
    public User findUserByUserNameAndPassword
    (String userName ,String password);
	
}
