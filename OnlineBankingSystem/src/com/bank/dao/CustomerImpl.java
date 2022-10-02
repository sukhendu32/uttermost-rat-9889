package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.bean.Customer;
import com.bank.utility.DButil;
import com.mysql.cj.xdevapi.DbDoc;

public class CustomerImpl implements CustomerDao {

	@Override
	public String newregister(String name, String email, String pass, int amount) {
		
		String msg="Not Registered";
		
		try(Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("  insert into customer (name,email,pass,amount) values(?,?,?,?)");
			
			
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pass);
			ps.setInt(4, amount);

			 int x= ps.executeUpdate();
			 
			 
			 
			 
			 
			
			
			 if(x>0)
				msg="Registered sucessfully"; 
			 
		} catch (SQLException e) {
			
			e.getMessage();
			
		}
			
		return msg;
	}

	
	
	@Override
	public Customer login(String email, String pass) {
		Customer c=null;
		
		try(Connection conn=DButil.provideConnection()) {
		
			
			PreparedStatement ps= conn.prepareStatement("select * from customer where email=? and pass=?");
			
			ps.setString(1, email);
			ps.setString(2, pass);
			 
			ResultSet rs= ps.executeQuery(); 
				
			
			if(rs.next()) {
				
										
				
				int an= rs.getInt("ac_no");
				String n= rs.getString("name");
				String m= rs.getString("email");
				String p= rs.getString("pass");
				int a= rs.getInt("amount");
				int l= rs.getInt("loan");
				
				
			    c=new Customer(an, n,m, p, a, l);
				
				
			    
			    System.out.println(c);
			    
			}
			
			
		} catch (Exception e) {
			
			
			e.getMessage();
		}
		
		
		
		return c;
	}



	@Override
	public void deposit(int amt,int acc) {
		
	  try(Connection conn= DButil.provideConnection()) {
		  
		  
		  PreparedStatement ps1=conn.prepareStatement("insert into deposit (ac_no,amount)values(?,?)");
		  
		  ps1.setInt(1, acc);
		  ps1.setInt(2, amt);
		  
		  int j=ps1.executeUpdate();
		  
		  PreparedStatement ps=conn.prepareStatement("update customer set  amount=amount+? where ac_no=?");
		  
		 ps.setInt(1, amt);
		 ps.setInt(2, acc);
		  
		  int i= ps.executeUpdate();
		  
		  
		  
		  
//		  PreparedStatement ps2=conn.prepareStatement("  insert into deposit (ac_no,amount) values(?,?)");
//			 
//			 ps2.setInt(1,acc );
//			 ps2.setInt(2, amt);
//			 
//			 ps2.executeUpdate();
		  
		  
		  if(i>0 && j>0)
			  System.out.println("Deposit made of Amount "+amt);
		  
		
	} catch (Exception e) {
		// TODO: handle exception
	}	
		
	
	}



	@Override
	public void moneyTransfer(int paya, int acc, int amt) {
		// TODO Auto-generated method stub
		
         if(paya<amt) {
			
			
			try(Connection conn=DButil.provideConnection()) {
				
				PreparedStatement ps1=conn.prepareStatement("insert into payment (ac_no,amount)values(?,?)");
				
				ps1.setInt(1, acc);
				ps1.setInt(2, paya);
			
				int z=ps1.executeUpdate(); 
				
				
				PreparedStatement ps=conn.prepareStatement("update customer set  amount=amount-? where ac_no=?");
				
				
				 ps.setInt(1, paya);
				 ps.setInt(2, acc);
				 
			    int x=ps.executeUpdate();
			    
			    
//			    PreparedStatement ps2=conn.prepareStatement("  insert into payment (ac_no,amount) values(?,?)");
//				 
//				 ps2.setInt(1,acc );
//				 ps2.setInt(2, paya);
//				 
//				 ps2.executeUpdate();
				
			    
			    if(x>0 && z>0)
			    	System.out.println("Payment made of Amount "+paya);
			    
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			
		}else {
			
			
			System.out.println("Not Enough Payment");
		}
		
	}



	@Override
	public void loanApply(int amt, int acc) {
		
		
		try(Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps1=conn.prepareStatement("select * from loanApply where ac_no=?");
			
			ps1.setInt(1, acc);
			
			ResultSet rs=ps1.executeQuery();
			
			if(rs.next()) {
				
				System.out.println("Already applied for loan");
				
			}else {
			
			
			PreparedStatement ps=conn.prepareStatement("insert into loanApply (ac_no,amount)values(?,?)");
			
			ps.setInt(1, acc);
			ps.setInt(2, amt);
			
			int i=ps.executeUpdate();
			
			if(i>0)
				System.out.println("Loan Applied....");
			
			
			
		  }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}



	






	
	
	
	
	
	

}
