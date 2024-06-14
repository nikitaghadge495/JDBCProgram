package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		String DriverClassName = "com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/acpjava";
		String userName ="root";
		String password = "Nikita@29";
		
		Class.forName(DriverClassName);
		Connection con = DriverManager.getConnection(url,userName,password);
		Statement stmt = con.createStatement();
		
		ResultSet rs= stmt.executeQuery("select * from emp");
		int empid,salary;
		String empname,stream;
		
		System.out.println("********************************coustmer Details******************************");
		System.out.println(" ");
		System.out.printf("%-10s %-20s %-30s %-10s%n", "empid", "Name", "stream", "salary");
	    System.out.println("-----------------------------------------------------------------------------");
		while(rs.next())
		{
			empid = rs.getInt(1);
			salary = rs.getInt(4);
			empname = rs.getString(2);
			stream = rs.getString(3);
			System.out.printf("%-10d %-20s %-30s %-10d%n", empid, empname, stream, salary);
            System.out.println("-----------------------------------------------------------------------------");
			
		}

	}

}
