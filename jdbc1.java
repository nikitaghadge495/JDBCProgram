package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acpjava","root","Nikita@29");
		
        Statement stmt = con.createStatement();
        int a = stmt.executeUpdate("insert into emp values(5,'nikita','IT',3456)");
        
        System.out.println("Sucessfully added employee"+a);
        con.close();
	}

}
