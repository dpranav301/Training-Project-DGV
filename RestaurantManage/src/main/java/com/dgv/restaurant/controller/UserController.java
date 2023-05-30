package com.dgv.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgv.restaurant.model.User;
import com.dgv.restaurant.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public User loginController(@RequestBody User user) {
		User loginUser = userService.loginUser(user);
		return loginUser;
	}

	@PostMapping("/register")
	public User registerControlller(@RequestBody User user) {
		User result = userService.register(user);
		return result;
	}
	@GetMapping("/allUser")
	public List<User> allUser()
	{
		List<User> user=userService.findByUser();
		return user;
	}

}
