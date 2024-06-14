package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		String DriverClassName = "com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/acpjava";
		String userName ="root";
		String password = "Nikita@29";
		//String query ="insert into student values(6,'Nikita','niki@gmail.com',789087)";
		
		String query = "UPDATE student SET stdName = 'krudnya' WHERE rollno = 4";
		Class.forName(DriverClassName);
		Connection con = DriverManager.getConnection(url,userName,password);
		
		Statement stmt = con.createStatement();
		
		int count = stmt.executeUpdate(query);
		System.out.println("connection establish successfully");
		System.out.println("no of rows affected by this query : "+count);
		
		con.close();
		
		

	}

}
