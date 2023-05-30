package com.dgv.controller;
//This is for validation purpose

import java.sql.SQLException;
import java.util.Scanner;

import com.dgv.pojo.Customer;
import com.dgv.service.UserService;

public class UserController
{
	Scanner scanner=new Scanner(System.in);
	private UserService userService;
	private String userName;
	private String userPassword;
	Customer customer;
	//For Registration Purpose
	public void registerUser()
	{
		System.out.println("Enter name ");
		userName=scanner.nextLine();
		System.out.println("Enter Password");
		userPassword=scanner.nextLine();
		customer=new Customer(userName,userPassword);
		//To Handle Exception 
		try {
			//From login controller we head towards User service
			new UserService().registerUserService(customer);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	//Login Purpose 
	public void loginCustomer() throws SQLException
	{
		String role = "";
		System.out.println("Enter Name");
		userName=scanner.nextLine();
		System.out.println("Enter Password");
		userPassword=scanner.nextLine();
		customer=new Customer(userName,userPassword);
		try {
			customer = new UserService().loginUserService(customer);
			//System.out.println(customer);
		} catch (SQLException e) {
			
		}
		//Here we check role of user and according to it we show them a menu
		if(customer.getRole().equalsIgnoreCase("Admin"))
		{
			AdminController.adminMenu();
		}
		else
		{
			CustomerController.customerMenu(customer);
		}
		
		
	}
}
