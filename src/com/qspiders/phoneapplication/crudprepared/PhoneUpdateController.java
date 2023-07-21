package com.qspiders.phoneapplication.crudprepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PhoneUpdateController {

	public static void main(String[] args) {
		System.out.println("Welcome to This Program To Update phone Information");
		Connection con=null;
		
		try {
			//step-1 load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 Create Connection 
			String url="jdbc:mysql://localhost:3306/phone_prepared_database";
			String user="root";
			String pass="root";	
			con=DriverManager.getConnection(url,user,pass);
			
			//Step-3 import query
			String update_query="update phone set name=? where id=?";
			
			//step-4 create prepared statemnet
			 
			PreparedStatement pst= con.prepareStatement(update_query);
			pst.setString(1, "OppoA7");
		    pst.setInt(2, 10);
		    
		    //step-5 execute statemnet
		    int a=pst.executeUpdate();
		    
		    if(a==1) 
		    {
		    	System.out.println("Congrass!! data is updated");
		    }else 
		    {
		     System.err.println("Sorry!! failed to update data ");
		     System.err.println("given id not found");
		    }
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally 
		{
			try {
				  con.close();
			    } catch (SQLException e)
			    {
				  e.printStackTrace();
		     	}
		}
		
		
		System.out.println("Thank You");
		
		
		
	}

}
