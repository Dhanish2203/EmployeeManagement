package com.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demo.entity.User;
import com.demo.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserRestController {
	private IUserService userService;

	@Autowired
	public UserRestController(IUserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId) {
		User theUser = userService.findById(userId);
		if (theUser == null) {
			throw new RuntimeException("user id not found- " + userId);
		}
		return theUser;
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User theUser) {
//		theEmployee.setId(0);
		theUser.setUserId(0);
		userService.save(theUser);
		return theUser;

	}

	@PutMapping("/users/{userId}")
	public User updateUser(@PathVariable int userId, @RequestBody User theUser) {
		User use = userService.findById(userId);
		if (theUser == null) {
			throw new RuntimeException("user id not found-" + userId);
		}

		use.setUserName(theUser.getUserName());
		use.setPassword(theUser.getPassword());
		use.setRole(theUser.getRole());
		userService.save(use);
		return use;
	}

	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		User theUser = userService.findById(userId);
		if (theUser == null) {
			throw new RuntimeException("user id not found-" + userId);
		}
		userService.deleteById(userId);
		return "Deleted employeeId: " + userId;
	}
	
	@GetMapping("/users/{userName}/{password}")
    public ResponseEntity<User>
    findUserByNameAndPassword(@PathVariable String userName,@PathVariable String password){
		User user = userService.findUserByUserNameAndPassword(userName, password);
		return ResponseEntity.status(200).body(user);
}
	
}