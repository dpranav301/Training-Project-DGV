package com.dgv.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.dgv.controller.UserController;

public class RestaurantMain {

	static Scanner scanner=new Scanner(System.in);
	static Integer choice;
	static UserController userController=new UserController();
	static Boolean exitLoop=false;
	public static void main(String[] args) throws SQLException {
		do {
		System.out.println("==================>Restaurant Management System<==============");
		
		System.out.println("1.Login\n2.Register\n3.Exit");
		System.out.println("Enter Your Choice");
		choice=scanner.nextInt();
		scanner.nextLine();
		switch(choice)
		{
		case 1:
			try {
				//This will Take To The Login logic
			userController.loginCustomer();
			}
			catch(NullPointerException e)
			{
				System.out.println("Invalid UserName and Password");
			}
			exitLoop=true;
			break;
		case 2:
			//This will Take To the register customer logic
			userController.registerUser();
			exitLoop=true;
			break;
		case 3:
			System.out.println("Application close Succesfully");
			System.exit(0);
		}
		}while(exitLoop);

	
	

}
}