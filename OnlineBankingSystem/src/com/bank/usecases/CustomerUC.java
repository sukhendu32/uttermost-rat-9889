package com.bank.usecases;

import java.util.Scanner;

import com.bank.bean.Customer;
import com.bank.dao.CustomerImpl;

public class CustomerUC {

	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		
		
       while(true) {
    	   
    	   System.out.println("Enter 1 to logIn as a customer");
    	   System.out.println("Enter 2 to register as a customer");
    	   
    	   int n=sc.nextInt();
    	   
    	   // login or register open
    	   if(n==1) {    
    		   
    		   System.out.println("Please Enter your EMAIl");
    		   String e=sc.next();
    		   System.out.println("Please Enter your Password");
    		   String p=sc.next();
    		   CustomerImpl ci=new CustomerImpl();
    		   
    		   Customer c= ci.login(e, p);
    		   
    		   
    		   
    		   
    		   if(c!=null) {
    			   
    			   
    			   System.out.println("Welcome" +c.getName());
    			   
    			   
    			   
    			   while(true) {
    				   
    				 System.out.println("Select 1 to check balance");
    				 System.out.println("select 2 to deposit amount");
    				 System.out.println("select 3 for payment");
    				 System.out.println("select 4 to take lone");
    				 
    				 int no=sc.nextInt();  				   
    				  
    				 if(no==1) {
    					 
    					 
    					 System.out.println("Your current balance "+c.getAmount());
    					 
    				 }else if(no==2) {
    					 
    					 
    					 
    					 System.out.println("Enter amount to deposit");
    					 int amt=sc.nextInt();
    					 
    					 ci.deposit(amt, c.getAccno());
    					 
    					 c.setAmount(c.getAmount()+amt);
    					 
    					 
    					 
    				 }else if(no==3) {
    					 
    					 
    					 System.out.println("Enter amount for Payment");
    					 int amt=sc.nextInt();
    					 
    					 ci.moneyTransfer(amt, c.getAccno(), c.getAmount());
    					 
    					 c.setAmount(c.getAmount()-amt);
    					 
    					 
    				 }else if(no==4) {
    					 
    					 System.out.println("Enter loan Amount");
    					 int amt=sc.nextInt();
    					 
    					 
    					 ci.loanApply(amt, c.getAccno());
    					 
    					 
    				 }
    				 
    				 
    				 
    				 
    				 System.out.println("wany to continue y/n");
    				 String s=sc.next();
    					
    				 if(s.equals("n") || s.equals("N")) {
    						
    						break;
    					}
    				   
    				   
    				   
    			   }
    			   
    			   
    			   
    			   
    		   }else {
    			   
    			   
    			   System.out.println("wrong email or password");
    		   }
    		   
    		   
    		   
    		   
    		   
    		   
    		   
    	   }else if(n==2) {
    		   
    		   System.out.println("please enter detail to register as a customer");
    		   
    		   CustomerImpl ci=new CustomerImpl();
    		   
    		   System.out.println("Enter your Name");
    		   String na=sc.next();
    		   System.out.println("Enter your Email");
    		   String e=sc.next();
    		   System.out.println("Enter your Password");
    		   String p=sc.next();
    		   System.out.println("Enter amount to deposit");
    		   int a=sc.nextInt();
    		   
    		   
    		   String msg= ci.newregister(na, e, p, a);
    		   
    		   System.out.println(msg);
    		   
    	   }
    	   
    	   
    	   System.out.println("wany to continue y/n");
			String s=sc.next();
			
			if(s.equals("n") || s.equals("N")) {
				
				break;
			}
    	   
    	   
       }
	 	
		
	}
	
	

}
