package com.bank.dao;

import com.bank.bean.Customer;

public interface CustomerDao {
	
	public String newregister(String name,String email,String pass,int amount);
	
	public Customer login(String email,String pass);
	
	public void deposit(int amt ,int acc);
	

}
