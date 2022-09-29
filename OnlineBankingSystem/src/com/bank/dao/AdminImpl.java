package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.bean.Admin;
import com.bank.exceptions.AdminExp;
import com.bank.utility.DButil;

public class AdminImpl implements AdminDao {

	@Override
	public Admin adminLogin(String email, String pass) throws AdminExp {
		
		Admin admin=null;
		
		
		try(Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from admin where email= ? AND pass = ?");
			
			ps.setString(1,email );
			ps.setString(2, pass);
			
			   ResultSet rs= ps.executeQuery();
			   
			   if(rs.next()) {
				   
				   int id=rs.getInt("id");
				   String name=rs.getString("name");
				   String eml=rs.getString("email");
				   
				   String pas=rs.getString("pass");
				   
				   
				   Admin a=new Admin(id, name, eml, pas);
				   
				   admin=a;
				   
			   }else {
				   
				   throw new AdminExp("Wrong username or password");
				   
			   }
			
			
			
		} catch (SQLException e) {
			
			
			throw new AdminExp(e.getMessage());
			
		} 
		
		
		return admin;
	}

}
