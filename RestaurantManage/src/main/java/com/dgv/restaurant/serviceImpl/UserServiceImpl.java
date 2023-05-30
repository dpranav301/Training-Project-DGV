package com.dgv.restaurant.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgv.restaurant.model.User;
import com.dgv.restaurant.repository.UserRepo;
import com.dgv.restaurant.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Override
	public User loginUser(User user) 
	{
		User loginUser=userRepo.findByUserNameAndUserPassword(user.getUserName(),user.getUserPassword());
		if(loginUser!=null)
			{
			System.out.println(loginUser);
			return loginUser;
			}
		return null;
		
		
	}
	@Override
	public User register(User user) {
		User registerUser=userRepo.save(user);
		//To save role of every customer as Customer
		user.setUserRole("customer");
//		if(registerUser==null)
//		{
//			return "User not register succesfully";
//		}
//		else
//		{
//			return "user Register Succesfully";
//		}
		return registerUser;
		
		
		
	}
	public User getById(Integer custId)
	{
		User getUser=userRepo.findById(custId).orElseThrow();
		return getUser;
	}
	@Override
	public List<User> findByUser() {
		List<User> user=userRepo.findAll();
		return user;
	}
	
	
	
	

}
