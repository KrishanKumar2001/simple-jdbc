package com.qspiders.phoneapplication.crudprepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class PhoneInputController2 {

	public static void main(String[] args) {
		
		//data insertion into phone table
		System.out.println("👨‍💻 Welcome To this program To store phone data 🧑‍💻");
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
			 
 //=====================================================================
			   Scanner sc=new Scanner(System.in);
			   
			   System.out.println("Enter 📱 phone id");
			   int id=sc.nextInt();
			 
			   sc.nextLine();
			   
			   System.out.println("Enter phone name");
			   String name=sc.nextLine();
			   
			   System.out.println("Enter 📱 phone color");
			   String color=sc.nextLine();
			  
			   System.out.println("Enter 📱 phone price");
			   double price=sc.nextDouble();
 //=====================================================================
			 pst.setInt(1, id);
			 pst.setString(2,name);
			 pst.setString(3,color);
			 pst.setDouble(4,price);
			 
			 //step-5 execute statemnet
			 int a=pst.executeUpdate();
			 
			 if(a==1) 
			 {
				 System.out.println("Congresss 🎉!!  phone 📱 "+name+ " Data is Stored ");
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
			
			System.out.println("Thank You 🫡!!");
		}
		
		
		
	
		
		
	}

}
