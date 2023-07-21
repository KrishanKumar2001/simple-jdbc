package com.qspiders.phoneapplication.crudprepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PhoneInputController {

	public static void main(String[] args) {
		
		//data insertion into phone table
		System.out.println("Welcome To this program To Insert data");
		Connection con=null;
		try {
			
			
			//step-1 load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 create connection
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_prepared_database","root","root");
			
			 //step-3 write query
			 String insert_query="insert into  phone values(?,?,?,?)";
			
			// staep-4  craete prepared statemnet
			 PreparedStatement pst=con.prepareStatement(insert_query);
			 pst.setInt(1, 10);
			 pst.setString(2,"oppo15");
			 pst.setString(3,"Black");
			 pst.setDouble(4,12000);
			 
			 //step-5 execute statemnet
			 int a=pst.executeUpdate();
			 
			 if(a==1) 
			 {
				 System.out.println("Congresss!! Data Stored into Database");
			 }else
			 {
				 System.err.println("Sorry!!! Failed to store data");
				 
			 }
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}finally 
		{
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		System.out.println("Thank You!!");
	
		
		
	}

}
