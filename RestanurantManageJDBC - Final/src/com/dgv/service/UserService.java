package com.dgv.service;

import java.sql.SQLException;
import java.util.List;

import com.dgv.dao.UserDao;
import com.dgv.daoImpl.UserDaoImpl;
import com.dgv.pojo.Customer;

public class UserService {

	private static UserDao userDao;
	public UserService()
	{
		userDao=new UserDaoImpl();
	}

	public void registerUserService(Customer customer) throws SQLException
	{
		//userDao=new UserDaoImpl();
		Integer customerAdd=userDao.registerUserDao(customer);
		System.out.println("User register Succesfully");
	}
	public Customer loginUserService(Customer customer) throws SQLException
	{
		Integer customerId;
		String role="";
		List<Customer> customerList=userDao.loginUserDao();
		for(Customer c:customerList)
		{
			if(c.getCustName().equals(customer.getCustName()) && c.getCustPassword().equals(customer.getCustPassword()))
			{
				customerId = c.getCustId();
				role=c.getRole();
				customer.setCustId(customerId);
				customer.setRole(role);
				break;
			}
			
		}
		return customer;
	}
	
}
