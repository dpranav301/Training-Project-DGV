package com.dgv.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.dgv.main.RestaurantMain;
import com.dgv.pojo.Customer;
import com.dgv.service.CustomerService;

public class CustomerController {

	static Integer customerOrderId=0;
	public static void customerMenu(Customer customer) throws SQLException
	{
		CustomerService customerService=new CustomerService();
		
		Scanner scanner=new Scanner(System.in);
		Integer choice=0;
		Boolean exitLoop=false;
		do {
		System.out.println("1.Order Food\n2.See Bill\n3.Logout");
		System.out.println("Enter Your choice");
		choice=scanner.nextInt();
		switch(choice)
		{
		case 1:
			//This will lead us towards customer service
			customerService.orderFood(customer);
			exitLoop=true;
			break;
		case 2:
			customerService.seeBillOfCustomer(customer);
			exitLoop=true;
			break;
		
		case 3:
			System.out.println("Logout Sucessfully");
			RestaurantMain.main(null);
			break;
			default:System.out.println("Invalid Choice");
		}
	}while(exitLoop);
	}
}
