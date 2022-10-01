package com.bank.usecases;

import java.util.Scanner;

import com.bank.bean.Admin;
import com.bank.dao.AdminImpl;
import com.bank.exceptions.AdminExp;

public class AdminUC {
	
	
	public static void main(String[] args) {
		
		AdminImpl aip=new AdminImpl();
		
		System.out.println("Please LOG IN");
		
		Scanner sc=new Scanner(System.in);
  		
		System.out.println("ENTER EMAIL ID");
		String m=sc.next();
		
		System.out.println("ENTER PASSWORD");
		String p=sc.next();
		
		Admin a=null;
	
			
			try {
				
				a = aip.adminLogin(m, p);
				
				System.out.println("LOG in SUCESS!!!"+a.getName());
				
				
				while(true) {
					
					System.out.println("select 1 to see List of Customers ");
					System.out.println("select 2 to Approve Loan");
					System.out.println("select 3 for Deposit Detail");
					System.out.println("select 4 for Payment Detail");
					System.out.println("select 5 for net balance");
					
					
					int no=sc.nextInt();
					
					
					if(no==1) {
						
						aip.customerDetail();
						
						
					}else if(no==2) {
						
						
					}
					
					
					
					 System.out.println("wany to continue y/n");
    				 String s=sc.next();
    					
    				 if(s.equals("n") || s.equals("N")) {
    						
    						break;
    					}
    				   
					
					
					
				}
				
				
				
				
				
				
				
			} catch (AdminExp e) {
				
				e.printStackTrace();
				
			}
			
			
		
		
		
		
	}

}
