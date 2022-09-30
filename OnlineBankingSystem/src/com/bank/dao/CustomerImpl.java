package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.bean.Customer;
import com.bank.utility.DButil;
import com.mysql.cj.xdevapi.DbDoc;

public class CustomerImpl implements CustomerDao {

	@Override
	public String newregister(String name, String email, String pass, int amount) {
		
		String msg="Not Registered";
		
		try(Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("  insert into customer (name,email,pass,amount) values('?','?','?',?)");
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pass);
			ps.setInt(4, amount);

			 int x= ps.executeUpdate();
			
			 if(x>0)
				msg="Registered sucessfully"; 
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		return msg;
	}

	
	
	@Override
	public Customer login(String email, String pass) {
		Customer c=null;
		
		try(Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from customer where email='?' and pass='?'");
			
			ps.setString(1, email);
			ps.setString(2, pass);
			 
			ResultSet rs= ps.executeQuery(); 
			
			
			if(rs.next()) {
				
				int acc=rs.getInt("acc_no");
				String name=rs.getString("name");
				String mail=rs.getString("email");
				String p=rs.getString("pass");
				int a=rs.getInt("amount");
				int l=rs.getInt("loan");
				
			    c=new Customer(acc, name, email, pass, a, l);
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return c;
	}



	@Override
	public void deposit(int amt,int acc) {
		
	  try(Connection conn= DButil.provideConnection()) {
		  
		  PreparedStatement ps=conn.prepareStatement("update customer set  amount=amount+? where ac_no=?");
		  
		 ps.setInt(1, acc);
		 ps.setInt(2, amt);
		  
		  
		  
		
	} catch (Exception e) {
		// TODO: handle exception
	}	
		
	
	}
	
	
	
	
	

}
