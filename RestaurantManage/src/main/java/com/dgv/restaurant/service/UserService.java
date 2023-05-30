package com.dgv.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dgv.restaurant.model.User;


public interface UserService {

	 public User loginUser(User user);
	 public User register(User user);
	 public User getById(Integer custId);
	 public List<User> findByUser();
}
