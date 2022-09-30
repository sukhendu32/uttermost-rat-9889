package com.bank.bean;

public class Customer {
	
	private int accno;
	private String name;
	private String email;
	private String pass;
	private int amount;
	private int loan;
	
	 
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getAccno() {
		return accno;
	}


	public void setAccno(int accno) {
		this.accno = accno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getLoan() {
		return loan;
	}


	public void setLoan(int loan) {
		this.loan = loan;
	}


	public Customer(int accno, String name, String email, String pass, int amount, int loan) {
		super();
		this.accno = accno;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.amount = amount;
		this.loan = loan;
	}


	@Override
	public String toString() {
		return "Customer [accno=" + accno + ", name=" + name + ", email=" + email + ", pass=" + pass + ", amount="
				+ amount + ", loan=" + loan + "]";
	}
	
	
	

}
