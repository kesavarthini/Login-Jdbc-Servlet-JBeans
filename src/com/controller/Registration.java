package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Registration {
	int count;

	public int Register(String username, int age, String password, String dept, String designation) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assign", "root", "Sapient123");
		/*	final String queryCheck = "SELECT count(*) from assign WHERE name = ? and password= ?";
			//final PreparedStatement ps = con.prepareStatement(queryCheck);
			ps.setString(1, username);
			ps.setString(2, password);
			final ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}*/
			VerificationBean verificationBean=new VerificationBean();
			
			if (verificationBean.Connectdatabase(username, password)!=true) 
			{
				PreparedStatement ps1 = con.prepareStatement("insert into assign values(?,?,?,?,?)");

				ps1.setString(1, username);
				ps1.setInt(2, age);
				ps1.setString(3, password);
				ps1.setString(4, dept);
				ps1.setString(5, designation);

				int i = ps1.executeUpdate();
				if (i>0) 
				{
					System.out.println("You are successfully registered...");
					return 1;
				}
				else
				{
					return 3;
				}
			} 
			else 
			{
				System.out.println("Account already exists");
				return 2;
			}
		}
		catch (Exception e2)
		{
			System.out.println(e2);
			return 3;
		}

	}

}