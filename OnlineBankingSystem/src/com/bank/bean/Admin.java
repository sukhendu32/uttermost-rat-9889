package com.bank.bean;

public class Admin {
	
  private int id;
  private String name;
  private String email;
  private String pass;
  
  
  
  public Admin() {
	  
	  
  }
  
  
  
  
@Override
public String toString() {
	return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + "]";
}




public Admin(int id, String name, String email, String pass) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.pass = pass;
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
  
  
  
  
	

}
