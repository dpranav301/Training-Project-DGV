package com.dgv.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.dgv.main.RestaurantMain;
import com.dgv.service.AdminService;

public class AdminController
{
	private static AdminService adminService;
	
	public static void adminMenu() throws SQLException
	{
		adminService=new AdminService();
		Scanner scanner=new Scanner(System.in);
		Integer choice=0;
		Boolean exitLoop=false;
		do {
			System.out.println("1.Add Inventory\n2.current Inventory\n3.customer Bill\n4.Delete Product\n5.Logout");
			choice=scanner.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Add Product To The Inventory");
				adminService.addInventoryService();
				exitLoop=true;
				break;
			case 2:
				System.out.println("Current Inventory is as follows");
				adminService.getInventoryService();
				exitLoop=true;
				break;
			case 3:
				System.out.println("Customer Bill");
				adminService.showListOfCustomer();
				exitLoop=true;
				break;
			case 4:
				adminService.deleteProductFromInventory();
				exitLoop=true;
				break;
			case 5:
				System.out.println("LogOut Sucessfully");
				RestaurantMain.main(null);
				break;
				default:System.out.println("Invalid Choice");
			}
			
		}while(exitLoop);
	}
}
