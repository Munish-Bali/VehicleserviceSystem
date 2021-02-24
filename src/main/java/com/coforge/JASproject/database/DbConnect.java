package com.coforge.JASproject.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	
	static Connection con=null;
	static String url="jdbc:mysql://localhost:3306/jewellery_automation";
	static String username="root";
	static String password="munish@123";
	
	public static Connection dbConnect() throws SQLException{
		
	try {
		System.out.println("Connection to Database");
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,username,password);
		System.out.println("Database Connected");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return con;
	}

}
