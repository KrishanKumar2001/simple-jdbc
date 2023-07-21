package com.qspiders.phoneapplication.crudprepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PhoneDeleteController {

	public static void main(String[] args) {
		
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_prepared_database","root","root");
			
		   String delete_query="delete from phone where id=?";
		   
		   PreparedStatement pst=con.prepareStatement(delete_query);
		   
		 
		  pst.setInt(1, 16);
		  int a= pst.executeUpdate();
		  if(a==1) 
		  {
			  System.out.println("Date is deleted");
		  }else
		  {
			  System.out.println("sorry!! Given id is not found");
		  }
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}finally 
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
