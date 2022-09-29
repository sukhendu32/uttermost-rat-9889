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
				
				System.out.println("LOG in SUCESS!!!");
				
				
				
				
				
			} catch (AdminExp e) {
				
				e.printStackTrace();
				
			}
			
			
		
		
		
		
	}

}
