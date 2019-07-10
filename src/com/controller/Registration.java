package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Registration {
    
	public boolean Register(String username,int age,String password,String dept,String designation) {
   
	try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assign","root","Sapient123");  
	  
	PreparedStatement ps=con.prepareStatement( "insert into assign values(?,?,?,?,?)");  
	  
	ps.setString(1,username);  
	ps.setInt(2,age);  
	ps.setString(3,password);  
	ps.setString(4,dept);  
	ps.setString(5,designation);  
	
	int i=ps.executeUpdate();  
	if(i>0)  
	System.out.println("You are successfully registered...");  
	return true;       
	}
	catch (Exception e2) {
		System.out.println(e2);
	return false;}  
	      
	}  
	  
	

}