package com.dgv.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dgv.restaurant.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	public User findByUserNameAndUserPassword(String userName,String userPassword);
}

	

