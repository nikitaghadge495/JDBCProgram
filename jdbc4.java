package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/acpjava";
		String userName ="root";
		String password = "Nikita@29";
		Connection con = DriverManager.getConnection(url,userName,password);
		
		Scanner sc = new Scanner(System.in);
		
		PreparedStatement psmt = con.prepareStatement("Insert into emp values(?,?,?,?)");
		
		System.out.println("enetr emp Id : ");
		int id = sc.nextInt();
		
		System.out.println("Enetr emp Name : ");
	    String Name = sc.next();
	    
	    System.out.println("enter emp Stream : ");
	    String stream = sc.next();
	     
	    System.out.println("Enetr emp Salary : ");
	    int salary = sc.nextInt();
	    
	    psmt.setInt(1,id);
	    psmt.setString(2,Name);
	    psmt.setString(3,stream);
	    psmt.setInt(4,salary);
	    
	    int r = psmt.executeUpdate();
	    System.out.println("record insert successfully");
	    
	    Statement stmt = con.createStatement();
	    
	    ResultSet rs = stmt.executeQuery("select * from emp");
	    
	    int empid,empsalary;
	    String empName,Stream;
	    
	    

	    
	    System.out.println("**************************************** Customer Details************************");
	    System.out.println(" ");
	    System.out.printf("%-10s %-20s %-30s %-10s%n", "EmpId", "EmpName", "Stream","Slarary");
	    System.out.println("----------------------------------------------------------------------------------");
	    while(rs.next())
	    {
	    	empid = rs.getInt(1);
	    	empName = rs.getString(2);
	    	Stream = rs.getString(3);
	    	empsalary = rs.getInt(4);
	    	System.out.println("%d");
	    	System.out.printf("%-10d %-20s %-30s %-10d%n", empid, empName, Stream, empsalary);
            System.out.println("-----------------------------------------------------------------------------");
	    }
	    
	    
//        Statement stmt = con.createStatement();
//		
//		ResultSet rs= stmt.executeQuery("select * from emp");
//		int empid,Empsalary;
//		String empname,Stream;
//		
//		System.out.println("********************************coustmer Details******************************");
//		System.out.println(" ");
//		System.out.printf("%-10s %-20s %-30s %-10s%n", "empid", "Name", "stream", "salary");
//	    System.out.println("-----------------------------------------------------------------------------");
//		while(rs.next())
//		{
//			empid = rs.getInt(1);
//			Empsalary = rs.getInt(4);
//			empname = rs.getString(2);
//			Stream = rs.getString(3);
//			System.out.printf("%-10d %-20s %-30s %-10d%n", empid, empname, Stream, Empsalary);
//            System.out.println("-----------------------------------------------------------------------------");
//			
//		}
	   
	    con.close();
	    
		
		

	}

}
