package com.bank.usecases;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("WELCOME TO ABC BANK");
		Scanner sc=new Scanner(System.in);		
		
		while(true) {
			
			System.out.println("Press 1 for Admin");
			System.out.println("Press 2 for Customer");
			int n=sc.nextInt();
			
			if(n==1) {
				
				AdminUC.main(null);
				
			}else if(n==2) {
				
				CustomerUC.main(null);
				
				
			}
			
			
			
			System.out.println("wany to continue y/n");
			String s=sc.next();
			
			if(s.equals("n") || s.equals("N")) {
				
				break;
			}
			
		}
		
		
		
		
	}
	

}
