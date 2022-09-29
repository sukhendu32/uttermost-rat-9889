package com.bank.utility;

import java.sql.Connection;

public class demo {
	
	public static void main(String[] args) {
		
		Connection con=DButil.provideConnection();
		
		System.out.println(con);
		
	}

}
