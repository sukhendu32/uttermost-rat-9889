package com.bank.dao;

import com.bank.bean.Admin;
import com.bank.exceptions.AdminExp;

public interface AdminDao {
	
	public Admin adminLogin(String email,String pass)throws AdminExp ;

}
