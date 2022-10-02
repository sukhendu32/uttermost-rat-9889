package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

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

	@Override
	public void customerDetail() {
		
		try(Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from customer");
			
			 ResultSet rs=  ps.executeQuery();
			
			 int count=1;
			 
			 while(rs.next()) {
				 
				 
				 
				System.out.println(count+" --> Account number : "+rs.getInt("ac_no"));
				System.out.println("Name : "+rs.getString("name"));
				System.out.println("Amount : "+rs.getInt("amount"));
				System.out.println("Loan amount : "+rs.getInt("loan"));
				
				 System.out.println("************************************************************");
				 count++;
				 
				 
			 }
			 
			 
			 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

	@Override
	public void loanApproved() {
		
		try(Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from loanApply");
			
			ResultSet rs=ps.executeQuery();
			
			int count=1;
			
			while(rs.next()) {
				
				int ac=rs.getInt("ac_no");
				int amt=rs.getInt("amount");
				String date=rs.getString("date");
				
				
				System.out.println(count+"Account no : "+ac);
				System.out.println("Loan amount applied : "+amt);
				System.out.println("Date in which loan is applied : "+date);
				
				count++;
				
				System.out.println("***************************************************************************");
			}
			
			
			
			System.out.println("##############################");
		 	
		 System.out.println("Select the account number to approve the loan");
		 Scanner sc=new Scanner(System.in);
		 
		 int acno=sc.nextInt();
		 
		 PreparedStatement ps1=conn.prepareStatement("select * from loanApply where ac_no=?");
		 
		  ps1.setInt(1, acno);
			
		  ResultSet rs1=ps.executeQuery();
		  
		  int amt=0;
		  
		  if(rs1.next()) {
			  
			  amt=rs1.getInt("amount");
			  
		  }else {
			  
			  
			  System.out.println("wrong account number");
		  }
		  
		  
		  
		  PreparedStatement ps2=conn.prepareStatement("insert into loanApproved (ac_no,amount)values(?,?)");
		  
		  ps2.setInt(1, acno);
		  ps2.setInt(2, amt);
			
		  
		 int z= ps2.executeUpdate();
		  
		 
		 if(z>0)
		  System.out.println("Loan Approved......");
		  
		  
		  PreparedStatement ps3=conn.prepareStatement("delete from loanApply where ac_no=?");
		  
		  ps3.setInt(1, acno);
		  
		  ps3.executeUpdate();
		  
		  
		  PreparedStatement ps4=conn.prepareStatement("update customer set loan=? and amount=amount+? where ac_no=? ");
		  
		  ps4.setInt(1, amt);
		  ps4.setInt(2, amt);
		  ps4.setInt(3, acno);
		  
		  ps4.executeUpdate();
		  
		  
         			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	@Override
	public void depositDetail() {
		
		try(Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from deposit");
			
			ResultSet rs= ps.executeQuery();
			
			int count=1;
			
			while(rs.next()) {
				
				
				int ac=rs.getInt("ac_no");
				int amt=rs.getInt("amount");
				String date=rs.getString("date");
				
				
				System.out.println(count+"Account no : "+ac);
				System.out.println("Deposit amount : "+amt);
				System.out.println("Date of deposit : "+date);
				count++;
				
				System.out.println("********************************************************************");
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	@Override
	public void paymentDetail() {
		// TODO Auto-generated method stub
		
try(Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from payment");
			
			ResultSet rs= ps.executeQuery();
			
			int count=1;
			
			while(rs.next()) {
				
				
				int ac=rs.getInt("ac_no");
				int amt=rs.getInt("amount");
				String date=rs.getString("date");
				
				
				System.out.println(count+"Account no : "+ac);
				System.out.println("Payment amount : "+amt);
				System.out.println("Date of payment : "+date);
				count++;
				
				System.out.println("********************************************************************");
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

}
