package com.controller;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class VerificationBean {

	public boolean Connectdatabase(String uname,String pwd) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assign","root","Sapient123");  
			PreparedStatement ps = con.prepareStatement("select name,password from assign where name=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Account match");
				return true;
			}
			System.out.println("Invalid");
			return false;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}}  
	}