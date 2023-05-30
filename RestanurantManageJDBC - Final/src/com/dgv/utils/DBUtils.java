package com.dgv.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {

	static Connection con;
	
	public static Connection main() {
		
		try {
			String url="jdbc:mysql://172.33.1.8:3306/training_database";
			String username="training_user";
			String password="Training@123";
			con=DriverManager.getConnection(url, username, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;

	}

}
